-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 23 Ara 2016, 18:28:55
-- Sunucu sürümü: 10.1.9-MariaDB
-- PHP Sürümü: 7.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kutuphane`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kisi`
--

CREATE TABLE `kisi` (
  `TC_no` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `kisi_adi` varchar(16) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
  `kisi_soyadi` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(32) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
  `alıs_tarihi` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `donus_tarihi` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `ceza` float UNSIGNED NOT NULL,
  `alinan_kitap` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Tablo döküm verisi `kisi`
--

INSERT INTO `kisi` (`TC_no`, `kisi_adi`, `kisi_soyadi`, `mail`, `alıs_tarihi`, `donus_tarihi`, `ceza`, `alinan_kitap`) VALUES
('27823445634', 'Burak', 'Çayır', 'progamerburak@gmail.com', '0', '0', 1.8, '0'),
('28606164216', 'Ramazan', 'Uysal', 'uysal800@gmail.com', '0', '0', 1.8, '0');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitap`
--

CREATE TABLE `kitap` (
  `kitap_adi` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `kitap_yazari` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `kitap_yayinevi` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `yayin_yili` int(10) UNSIGNED NOT NULL,
  `ISBN_no` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `barkod` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `kitap_kopya_sayisi` int(10) UNSIGNED NOT NULL,
  `odunc` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Tablo döküm verisi `kitap`
--

INSERT INTO `kitap` (`kitap_adi`, `kitap_yazari`, `kitap_yayinevi`, `yayin_yili`, `ISBN_no`, `barkod`, `kitap_kopya_sayisi`, `odunc`) VALUES
('Otomatik Portakal', 'Anthony Burgess', 'İş Bankası Kültür Yayınları', 2009, '9709944885706', '970K02009', 0, 0),
('1984', 'George Orwell', 'Can Yayınları', 2016, '9719755100418', '971K02016', 0, 0),
('Kürk Mantolu Madonna', 'Sebahattin Ali', 'Yapı Kredi Yayınları', 2016, '9753638027', '975K02016', 0, 0),
('Tutunamayanlar', 'Oğuz Atay', 'İletişim Yayıncılık', 2014, '9754700117', '975K02014', 0, 0),
('Şato', 'Franz Kafka', 'Zeplin Yayınları', 2016, '9786059691802', '605K02016', 0, 0),
('Yabancı', 'Albert Camus', 'Can Yayınları', 2016, '9789750724756', '978K02016', 0, 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personel`
--

CREATE TABLE `personel` (
  `TC_no` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `sicil_no` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `personel_adi` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `personel_soyadi` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `personel_unvani` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `personel_sifre` varchar(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Tablo döküm verisi `personel`
--

INSERT INTO `personel` (`TC_no`, `sicil_no`, `personel_adi`, `personel_soyadi`, `personel_unvani`, `personel_sifre`) VALUES
('27823445634', '278234100', 'Burak', 'Çayır', 'Mühendis', '123456'),
('28606164216', '286061100', 'Ramazan', 'Uysal', 'Mühendis', '123456');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kisi`
--
ALTER TABLE `kisi`
  ADD PRIMARY KEY (`TC_no`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- Tablo için indeksler `kitap`
--
ALTER TABLE `kitap`
  ADD PRIMARY KEY (`ISBN_no`),
  ADD UNIQUE KEY `barkod` (`barkod`);

--
-- Tablo için indeksler `personel`
--
ALTER TABLE `personel`
  ADD PRIMARY KEY (`sicil_no`),
  ADD UNIQUE KEY `TC_no` (`TC_no`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
