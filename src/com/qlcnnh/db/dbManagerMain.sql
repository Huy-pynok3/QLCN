/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  T14
 * Created: May 23, 2024
 */
USE dbManagerShop
GO
CREATE TABLE PhieuThu
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	[nameKh] NVARCHAR(255) NOT NULL,
	[address] NVARCHAR(255) NOT NULL,
	dateCreate DATE, 
	lyDo NVARCHAR(255) NOT NULL,
	price MONEY,
)
GO

CREATE TABLE SoTietKiem
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	[chiNhanh] NVARCHAR(255) NOT NULL,
	[kyHan] NVARCHAR(255) NOT NULL,
	[maKh] NVARCHAR(255) NOT NULL,
	[tenKh] NVARCHAR(255) NOT NULL,
	[cccd] NVARCHAR(255) NOT NULL,
	[soTk] NVARCHAR(255) NOT NULL,
        soTien MONEY,
	laiSuat DECIMAL(5, 2) NOT NULL,
	ngayMoSo DATE, 
	[address] NVARCHAR(255) NOT NULL,
)
GO

CREATE TABLE KyHan
(
	idKyHan INT IDENTITY(1,1) PRIMARY KEY,
	valueKyHan VARCHAR(10) NOT NULL,

)
GO

