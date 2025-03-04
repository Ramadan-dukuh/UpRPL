-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 04, 2025 at 03:48 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uprpl`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `Id` int(5) NOT NULL,
  `noOrder` varchar(15) NOT NULL,
  `idProduk` varchar(6) NOT NULL,
  `harga` int(25) NOT NULL,
  `jumlah` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`Id`, `noOrder`, `idProduk`, `harga`, `jumlah`) VALUES
(1, 'NO001', 'CUS001', 30000, 5),
(2, 'NO001', 'CUS002', 10000, 10);

--
-- Triggers `detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `update_stock` AFTER INSERT ON `detail_transaksi` FOR EACH ROW BEGIN
    -- Hanya update stok jika produk adalah 'barang'
    IF (SELECT jenisProduk FROM produk WHERE idProduk = NEW.idProduk) = 'barang' THEN
        UPDATE produk 
        SET stock = stock - NEW.jumlah
        WHERE idProduk = NEW.idProduk;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `idPetugas` int(5) NOT NULL,
  `nmPetugas` varchar(100) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `kelas` enum('X RPL 1','X RPL 2','XI RPL 1','XI RPL 2','XII RPL 1','XII RPL  2','Guru') NOT NULL,
  `level` enum('Guru','Siswa','Suplier') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`idPetugas`, `nmPetugas`, `username`, `password`, `kelas`, `level`) VALUES
(1, 'Suplier', 'Suplier', 'suplier', 'Guru', 'Suplier'),
(2, 'Oktaviana Marpaung', 'Bu Okta', 'admin', 'Guru', 'Guru'),
(3, 'Eva Yepriliyanti', 'Bu Eva', 'admin', 'Guru', 'Guru'),
(4, 'Raditya Dwi Pahlawadi', 'Deddy', 'user', 'XI RPL 2', 'Siswa'),
(5, 'Daffa', 'DaigoX', '123', 'XI RPL 2', 'Siswa'),
(6, 'Restu', 'Mabes', '123', 'XI RPL 2', 'Siswa');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `idProduk` varchar(6) NOT NULL,
  `nmProduk` varchar(50) NOT NULL,
  `jenisProduk` enum('barang','jasa') NOT NULL,
  `hargaBeli` int(10) NOT NULL,
  `hargaJual` int(10) NOT NULL,
  `stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`idProduk`, `nmProduk`, `jenisProduk`, `hargaBeli`, `hargaJual`, `stock`) VALUES
('CUS001', 'Custom Mug', 'barang', 20000, 30000, 95),
('CUS002', 'Custom Totebag', 'barang', 5000, 10000, 90),
('CUS003', 'Custom Calendar', 'barang', 25000, 35000, 0),
('FOT001', 'Fotocopy', 'jasa', 0, 1000, 0),
('PRI001', 'Print', 'jasa', 0, 1000, 0);

--
-- Triggers `produk`
--
DELIMITER $$
CREATE TRIGGER `before_insert_produk` BEFORE INSERT ON `produk` FOR EACH ROW BEGIN
    DECLARE prefix VARCHAR(10);
    DECLARE lastNumber INT;
    DECLARE newID VARCHAR(6);

    -- Ambil huruf konsonan dari nama produk
    SET prefix = UPPER(
        CONCAT(
            SUBSTRING_INDEX(NEW.nmProduk, ' ', 1),  -- Ambil kata pertama
            SUBSTRING_INDEX(NEW.nmProduk, ' ', -1)  -- Ambil kata terakhir
        )
    );

    -- Ambil 3 huruf pertama sebagai kode produk
    SET prefix = UPPER(CONCAT(
        SUBSTRING(NEW.nmProduk, 1, 1),
        SUBSTRING(NEW.nmProduk, 2, 1),
        SUBSTRING(NEW.nmProduk, 3, 1)
    ));

    -- Cek ID terakhir berdasarkan prefix
    SELECT COALESCE(MAX(CAST(SUBSTRING(idProduk, 4, 3) AS UNSIGNED)), 0) + 1 
    INTO lastNumber
    FROM produk
    WHERE idProduk LIKE CONCAT(prefix, '%');

    -- Format angka menjadi 3 digit
    SET newID = CONCAT(prefix, LPAD(lastNumber, 3, '0'));

    -- Tetapkan nilai idProduk
    SET NEW.idProduk = newID;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `suplier`
--

CREATE TABLE `suplier` (
  `kodeSuplier` int(11) NOT NULL,
  `nmSuplier` varchar(30) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suplier`
--

INSERT INTO `suplier` (`kodeSuplier`, `nmSuplier`, `alamat`) VALUES
(1, 'Suplier', 'Dirumah lu');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `noOrder` varchar(15) NOT NULL,
  `tglTransaksi` date NOT NULL,
  `nmPelanggan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`noOrder`, `tglTransaksi`, `nmPelanggan`) VALUES
('NO001', '2025-03-04', 'Restu');

--
-- Triggers `transaksi`
--
DELIMITER $$
CREATE TRIGGER `before_insert_transaksi` BEFORE INSERT ON `transaksi` FOR EACH ROW BEGIN
    DECLARE last_noOrder VARCHAR(15);
    DECLARE new_noOrder INT;

    -- Ambil noOrder terakhir
    SELECT MAX(noOrder) INTO last_noOrder FROM transaksi WHERE noOrder LIKE 'NO%';

    -- Jika belum ada data, mulai dari NO001
    IF last_noOrder IS NULL THEN
        SET new_noOrder = 1;
    ELSE
        -- Ambil angka dari noOrder terakhir, ubah ke integer, lalu tambah 1
        SET new_noOrder = CAST(SUBSTRING(last_noOrder, 3) AS UNSIGNED) + 1;
    END IF;

    -- Format menjadi NO### (contoh: NO001, NO002, NO010, NO100)
    SET NEW.noOrder = CONCAT('NO', LPAD(new_noOrder, 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_suplier`
--

CREATE TABLE `transaksi_suplier` (
  `nmSuplier` varchar(50) NOT NULL,
  `idTrsuplier` varchar(6) NOT NULL,
  `idProduk` varchar(6) NOT NULL,
  `jumlah` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi_suplier`
--

INSERT INTO `transaksi_suplier` (`nmSuplier`, `idTrsuplier`, `idProduk`, `jumlah`) VALUES
('PT Berkah Selalu', 'ID001', 'CUS001', 5);

--
-- Triggers `transaksi_suplier`
--
DELIMITER $$
CREATE TRIGGER `before_insert_transaksi_suplier` BEFORE INSERT ON `transaksi_suplier` FOR EACH ROW BEGIN
    DECLARE last_idTrsuplier VARCHAR(6);
    DECLARE new_idTrsuplier INT;

    -- Ambil idTrsuplier terakhir yang memiliki format 'ID%'
    SELECT MAX(idTrsuplier) INTO last_idTrsuplier 
    FROM transaksi_suplier 
    WHERE idTrsuplier LIKE 'ID%';

    -- Jika belum ada data, mulai dari ID001
    IF last_idTrsuplier IS NULL THEN
        SET new_idTrsuplier = 1;
    ELSE
        -- Ambil angka dari ID terakhir, ubah ke integer, lalu tambah 1
        SET new_idTrsuplier = CAST(SUBSTRING(last_idTrsuplier, 3) AS UNSIGNED) + 1;
    END IF;

    -- Format menjadi ID### (contoh: ID001, ID002, ID010, ID100)
    SET NEW.idTrsuplier = CONCAT('ID', LPAD(new_idTrsuplier, 3, '0'));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tambah_stock` AFTER INSERT ON `transaksi_suplier` FOR EACH ROW BEGIN
    -- Hanya update stok jika produk adalah 'barang'
    IF (SELECT jenisProduk FROM produk WHERE idProduk = NEW.idProduk) = 'barang' THEN
        UPDATE produk 
        SET stock = stock + NEW.jumlah
        WHERE idProduk = NEW.idProduk;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `transaksi_view`
-- (See below for the actual view)
--
CREATE TABLE `transaksi_view` (
`noOrder` varchar(15)
,`tglTransaksi` date
,`nmPelanggan` varchar(50)
,`idProduk` varchar(6)
,`nmProduk` varchar(50)
,`harga` int(25)
,`jumlah` int(10)
,`total` bigint(35)
);

-- --------------------------------------------------------

--
-- Structure for view `transaksi_view`
--
DROP TABLE IF EXISTS `transaksi_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `transaksi_view`  AS SELECT `t`.`noOrder` AS `noOrder`, `t`.`tglTransaksi` AS `tglTransaksi`, `t`.`nmPelanggan` AS `nmPelanggan`, `p`.`idProduk` AS `idProduk`, `p`.`nmProduk` AS `nmProduk`, `d`.`harga` AS `harga`, `d`.`jumlah` AS `jumlah`, `d`.`harga`* `d`.`jumlah` AS `total` FROM ((`transaksi` `t` join `detail_transaksi` `d` on(`t`.`noOrder` = `d`.`noOrder`)) join `produk` `p` on(`d`.`idProduk` = `p`.`idProduk`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `idProduk` (`idProduk`),
  ADD KEY `noOrder` (`noOrder`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`idPetugas`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`idProduk`);

--
-- Indexes for table `suplier`
--
ALTER TABLE `suplier`
  ADD PRIMARY KEY (`kodeSuplier`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`noOrder`);

--
-- Indexes for table `transaksi_suplier`
--
ALTER TABLE `transaksi_suplier`
  ADD PRIMARY KEY (`idTrsuplier`),
  ADD KEY `idProduk` (`idProduk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `Id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `idPetugas` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`idProduk`) REFERENCES `produk` (`idProduk`);

--
-- Constraints for table `transaksi_suplier`
--
ALTER TABLE `transaksi_suplier`
  ADD CONSTRAINT `transaksi_suplier_ibfk_1` FOREIGN KEY (`idProduk`) REFERENCES `produk` (`idProduk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
