USE [master]
GO
/****** Object:  Database [QuanLyPhongTro1]    Script Date: 12/21/2020 2:14:37 PM ******/
CREATE DATABASE [QuanLyPhongTro1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'[QuanLyPhongTro1]', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\[QuanLyPhongTro1].mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'[QuanLyPhongTro1]_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\[QuanLyPhongTro1]_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLyPhongTro1] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyPhongTro1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyPhongTro1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyPhongTro1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyPhongTro1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyPhongTro1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyPhongTro1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyPhongTro1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyPhongTro1] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyPhongTro1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyPhongTro1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyPhongTro1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyPhongTro1] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QuanLyPhongTro1]
GO
/****** Object:  Table [dbo].[CT_DichVu]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_DichVu](
	[maDichVu] [nvarchar](50) NOT NULL,
	[maHoaDon] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
	[tongTien] [int] NULL,
 CONSTRAINT [PK_CT_DichVu] PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC,
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CT_HopDong]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HopDong](
	[maHopDong] [nvarchar](50) NOT NULL,
	[maKhachHang] [nvarchar](50) NOT NULL,
	[chuPhong] [nvarchar](50) NULL,
	[maPhong] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_HopDong] PRIMARY KEY CLUSTERED 
(
	[maHopDong] ASC,
	[maKhachHang] ASC,
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDichVu] [nvarchar](50) NOT NULL,
	[tenDichVu] [nvarchar](50) NULL,
	[trangThai] [nvarchar](50) NULL,
	[donGia] [nvarchar](50) NULL,
	[donViTinh] [nvarchar](50) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](50) NOT NULL,
	[maHopDong] [nvarchar](50) NULL,
	[ngayTao] [nvarchar](50) NULL,
	[tienDaThu] [nvarchar](50) NULL,
	[tongTien] [nvarchar](50) NULL,
	[trangThai] [nvarchar](50) NULL,
	[ghiChu] [nvarchar](50) NULL,
	[maPhong] [nvarchar](50) NULL,
	[maNhanVien] [nvarchar](50) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HopDongThue]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDongThue](
	[maHopDong] [nvarchar](50) NOT NULL,
	[ngayTao] [nvarchar](50) NULL,
	[ghiChu] [nvarchar](50) NULL,
	[trangThaiHopDong] [nvarchar](50) NULL,
 CONSTRAINT [PK_HopDongThue] PRIMARY KEY CLUSTERED 
(
	[maHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](50) NOT NULL,
	[tenKhachHang] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[sdt] [nvarchar](50) NULL,
	[trangThai] [nvarchar](50) NULL,
	[maHopDong] [nchar](10) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](50) NOT NULL,
	[tenNhanVien] [nvarchar](50) NULL,
	[diaChi] [nvarchar](max) NULL,
	[sdt] [nvarchar](50) NULL,
	[cmnd] [nvarchar](50) NULL,
	[trangThai] [nvarchar](50) NULL,
	[maTaiKhoan] [nvarchar](50) NULL,
	[chucVu] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Phong]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [nvarchar](50) NOT NULL,
	[giaPhong] [nvarchar](50) NULL,
	[trangThaiPhong] [nvarchar](50) NULL,
	[trangThai] [nvarchar](50) NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/21/2020 2:14:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTaiKhoan] [nvarchar](50) NOT NULL,
	[tenTaiKhoan] [nvarchar](50) NULL,
	[matKhau] [nvarchar](50) NULL,
	[trangThai] [nvarchar](50) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[CT_DichVu] ([maDichVu], [maHoaDon], [soLuong], [tongTien]) VALUES (N'DV0002', N'HD201209140342489', 2, 16000)
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [trangThai], [donGia], [donViTinh]) VALUES (N'DV0001', N'Điện', N'true', N'3500', N'KW')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [trangThai], [donGia], [donViTinh]) VALUES (N'DV0002', N'Nước', N'true', N'8000', N'Khối')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [trangThai], [donGia], [donViTinh]) VALUES (N'DV0003', N'Giữ xe', N'true', N'80000', N'Chiếc')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [trangThai], [donGia], [donViTinh]) VALUES (N'DV0004', N'Internet', N'true', N'120000', N'tháng')
INSERT [dbo].[HoaDon] ([maHoaDon], [maHopDong], [ngayTao], [tienDaThu], [tongTien], [trangThai], [ghiChu], [maPhong], [maNhanVien]) VALUES (N'HD201209114433916', N'KH201209110925123', N'09-12-2020', NULL, N'1500000', N'true', NULL, N'P03', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [maHopDong], [ngayTao], [tienDaThu], [tongTien], [trangThai], [ghiChu], [maPhong], [maNhanVien]) VALUES (N'HD201209140342489', N'KH0003', N'09-12-2020', NULL, N'1516000', N'true', NULL, N'P02', N'NV0001')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [diaChi], [sdt], [trangThai], [maHopDong]) VALUES (N'KH0001', N'Nguyen VAn A', N'0', N'0', N'false', NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [diaChi], [sdt], [trangThai], [maHopDong]) VALUES (N'KH0002', N'Nguyen Van B', N'12 Nguyen Van Bao', N'012456789', N'true', NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [diaChi], [sdt], [trangThai], [maHopDong]) VALUES (N'KH0003', N'Nguyen Van C', N'12 Nguyen Van Luong', N'012456789', N'true', NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [diaChi], [sdt], [trangThai], [maHopDong]) VALUES (N'KH201209110925123', N'phing tes', N'123456', N'123486', N'false', NULL)
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [sdt], [cmnd], [trangThai], [maTaiKhoan], [chucVu]) VALUES (N'NV0001', N'Quan Van LY', N'0', N'0', N'0', N'true', N'TK0001', N'ADMIN')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [sdt], [cmnd], [trangThai], [maTaiKhoan], [chucVu]) VALUES (N'NV0002', N'Trieu', N'0', N'0', N'0', N'true', N'TK0002', N'NHANVIEN')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [trangThaiPhong], [trangThai]) VALUES (N'P01', N'1500000', N'DANGO', N'fasle')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [trangThaiPhong], [trangThai]) VALUES (N'P02', N'1500000', N'DANGO', N'true')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [trangThaiPhong], [trangThai]) VALUES (N'P03', N'1500000', N'TRONG', N'true')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [trangThaiPhong], [trangThai]) VALUES (N'P04', N'2000000', N'DANGO', N'true')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [trangThaiPhong], [trangThai]) VALUES (N'P05', N'2500000', N'DANGO', N'true')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [trangThaiPhong], [trangThai]) VALUES (N'P06', N'1000000', N'TRONG', N'true')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [trangThaiPhong], [trangThai]) VALUES (N'P07', N'12123', N'TRONG', N'true')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [trangThaiPhong], [trangThai]) VALUES (N'P10', N'1231', N'TRONG', N'true')
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [tenTaiKhoan], [matKhau], [trangThai]) VALUES (N'TK0001', N'admin', N'12345678', N'true')
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [tenTaiKhoan], [matKhau], [trangThai]) VALUES (N'TK0002', N'a', N'a', N'true')
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_NhanVien_1]    Script Date: 12/21/2020 2:14:37 PM ******/
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [IX_NhanVien_1] UNIQUE NONCLUSTERED 
(
	[maTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CT_DichVu]  WITH CHECK ADD  CONSTRAINT [FK_CT_DichVu_DichVu] FOREIGN KEY([maDichVu])
REFERENCES [dbo].[DichVu] ([maDichVu])
GO
ALTER TABLE [dbo].[CT_DichVu] CHECK CONSTRAINT [FK_CT_DichVu_DichVu]
GO
ALTER TABLE [dbo].[CT_DichVu]  WITH CHECK ADD  CONSTRAINT [FK_CT_DichVu_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[CT_DichVu] CHECK CONSTRAINT [FK_CT_DichVu_HoaDon]
GO
ALTER TABLE [dbo].[CT_HopDong]  WITH CHECK ADD  CONSTRAINT [FK_CT_HopDong_HopDongThue] FOREIGN KEY([maHopDong])
REFERENCES [dbo].[HopDongThue] ([maHopDong])
GO
ALTER TABLE [dbo].[CT_HopDong] CHECK CONSTRAINT [FK_CT_HopDong_HopDongThue]
GO
ALTER TABLE [dbo].[CT_HopDong]  WITH CHECK ADD  CONSTRAINT [FK_CT_HopDong_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[CT_HopDong] CHECK CONSTRAINT [FK_CT_HopDong_KhachHang]
GO
ALTER TABLE [dbo].[CT_HopDong]  WITH CHECK ADD  CONSTRAINT [FK_CT_HopDong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[CT_HopDong] CHECK CONSTRAINT [FK_CT_HopDong_Phong]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Phong]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([maTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([maTaiKhoan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
USE [master]
GO
ALTER DATABASE [QuanLyPhongTro1] SET  READ_WRITE 
GO
