-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Jan 27. 11:05
-- Kiszolgáló verziója: 10.4.19-MariaDB
-- PHP verzió: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `lifestyle_app`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `auth`
--

CREATE TABLE `auth` (
  `authid` int(11) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `data`
--

CREATE TABLE `data` (
  `dataid` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ingredients`
--

CREATE TABLE `ingredients` (
  `ingredientsid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `meals`
--

CREATE TABLE `meals` (
  `mealsid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `meal_ingredients`
--

CREATE TABLE `meal_ingredients` (
  `meals_id` int(11) NOT NULL,
  `ingredients_id` int(11) NOT NULL,
  `calorievalue` int(11) NOT NULL,
  `fat` int(11) NOT NULL,
  `protein` int(11) NOT NULL,
  `carbohydrate` int(11) NOT NULL,
  `salt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `aid` int(11) NOT NULL,
  `did` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`authid`);

--
-- A tábla indexei `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`dataid`);

--
-- A tábla indexei `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`ingredientsid`);

--
-- A tábla indexei `meals`
--
ALTER TABLE `meals`
  ADD PRIMARY KEY (`mealsid`);

--
-- A tábla indexei `meal_ingredients`
--
ALTER TABLE `meal_ingredients`
  ADD KEY `meals_id` (`meals_id`),
  ADD KEY `ingredients_id` (`ingredients_id`);

--
-- A tábla indexei `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`),
  ADD KEY `authtid` (`aid`),
  ADD KEY `dataid` (`did`);

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `meal_ingredients`
--
ALTER TABLE `meal_ingredients`
  ADD CONSTRAINT `ingredients_id` FOREIGN KEY (`ingredients_id`) REFERENCES `ingredients` (`ingredientsid`),
  ADD CONSTRAINT `meals_id` FOREIGN KEY (`meals_id`) REFERENCES `meals` (`mealsid`);

--
-- Megkötések a táblához `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `authtid` FOREIGN KEY (`aid`) REFERENCES `auth` (`authid`),
  ADD CONSTRAINT `dataid` FOREIGN KEY (`did`) REFERENCES `data` (`dataid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
