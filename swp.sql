USE [master]
GO
/****** Object:  Database [SWP391]    Script Date: 8/4/2023 10:30:38 PM ******/
CREATE DATABASE [SWP391]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SWP391', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.KAIX\MSSQL\DATA\SWP391.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SWP391_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.KAIX\MSSQL\DATA\SWP391_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [SWP391] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SWP391].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SWP391] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SWP391] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SWP391] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SWP391] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SWP391] SET ARITHABORT OFF 
GO
ALTER DATABASE [SWP391] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [SWP391] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SWP391] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SWP391] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SWP391] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SWP391] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SWP391] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SWP391] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SWP391] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SWP391] SET  ENABLE_BROKER 
GO
ALTER DATABASE [SWP391] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SWP391] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SWP391] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SWP391] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SWP391] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SWP391] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SWP391] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SWP391] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SWP391] SET  MULTI_USER 
GO
ALTER DATABASE [SWP391] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SWP391] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SWP391] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SWP391] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SWP391] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SWP391] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [SWP391] SET QUERY_STORE = OFF
GO
USE [SWP391]
GO
/****** Object:  Table [dbo].[Admins]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admins](
	[AdminID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](max) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Dob] [date] NULL,
	[Phonenumber] [nvarchar](10) NOT NULL,
	[Address] [nvarchar](100) NULL,
	[Email] [nvarchar](50) NOT NULL,
	[TeacherDescription] [nvarchar](300) NULL,
	[RoleA] [nvarchar](50) NOT NULL,
	[adminStatus] [bit] NULL,
	[aImage] [nvarchar](300) NULL,
	[RememberMe] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[AdminID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BookOfCourse]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookOfCourse](
	[Course_BookID] [int] NULL,
	[CourseID] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course](
	[CourseID] [int] IDENTITY(1,1) NOT NULL,
	[CourseName] [nvarchar](50) NOT NULL,
	[CoursePrice] [float] NOT NULL,
	[CoursePropose] [bit] NOT NULL,
	[CourseDescription] [nvarchar](300) NULL,
	[CourseCreateDate] [datetime] NOT NULL,
	[CourseImage] [nvarchar](300) NULL,
	[NumberStudentEnrolled] [int] NULL,
	[LinkCourse] [nvarchar](300) NULL,
	[courseStatus] [bit] NULL,
	[adminID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[CourseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course_Book]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course_Book](
	[Course_BookID] [int] IDENTITY(1,1) NOT NULL,
	[BookName] [nvarchar](50) NULL,
	[Price] [float] NULL,
	[Bookstatus] [bit] NULL,
	[BookImg] [nvarchar](300) NULL,
	[StockQuantity] [int] NULL,
	[bDescription] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[Course_BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course_Category]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course_Category](
	[Course_CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[Course_CategoryName] [nvarchar](30) NULL,
	[Course_CategoryImg] [nvarchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[Course_CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course_Document]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course_Document](
	[Course_DocumentID] [int] IDENTITY(1,1) NOT NULL,
	[DocumentName] [nvarchar](100) NULL,
	[DocumentLink] [nvarchar](300) NULL,
	[status] [bit] NULL,
	[CourseVideoID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Course_DocumentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course_Process]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course_Process](
	[Course_ProcessID] [int] IDENTITY(1,1) NOT NULL,
	[Course_ProcessName] [nvarchar](50) NULL,
	[Course_ProcessImage] [nvarchar](300) NULL,
	[cpStatus] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Course_ProcessID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CourseVideo]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CourseVideo](
	[CourseVideoID] [int] IDENTITY(1,1) NOT NULL,
	[VideoName] [nvarchar](100) NULL,
	[VideoOrder] [int] NULL,
	[VideoLink] [nvarchar](300) NULL,
	[CourseID] [int] NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[CourseVideoID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Discount]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Discount](
	[DiscountID] [int] IDENTITY(1,1) NOT NULL,
	[Discount] [int] NULL,
	[CreateDiscountDate] [datetime] NOT NULL,
	[AdminID] [int] NULL,
	[CourseID] [int] NULL,
	[discountStatus] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[DiscountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hasCategory]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hasCategory](
	[CourseID] [int] NOT NULL,
	[Course_CategoryID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CourseID] ASC,
	[Course_CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[include]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[include](
	[CourseID] [int] NOT NULL,
	[Course_ProcessID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CourseID] ASC,
	[Course_ProcessID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[News]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[NewsID] [int] IDENTITY(1,1) NOT NULL,
	[CreateNewDate] [datetime] NOT NULL,
	[NewsTitle] [nvarchar](200) NULL,
	[News] [nvarchar](max) NULL,
	[NewsImg] [nvarchar](300) NULL,
	[AdminID] [int] NULL,
	[NewsStatus] [bit] NULL,
	[newsTypeID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[NewsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[newsType]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[newsType](
	[newsTypeID] [int] IDENTITY(1,1) NOT NULL,
	[newTypeName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[newsTypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderBook]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderBook](
	[OrderID] [int] NOT NULL,
	[Course_BookID] [int] NOT NULL,
	[price] [int] NULL,
	[quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC,
	[Course_BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderID] [int] NOT NULL,
	[CourseID] [int] NOT NULL,
	[price] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC,
	[CourseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[OrderDate] [datetime] NOT NULL,
	[CheckPaymentStatus] [bit] NOT NULL,
	[TotalPrice] [float] NOT NULL,
	[orderStatus] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 8/4/2023 10:30:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](max) NULL,
	[Fullname] [nvarchar](50) NULL,
	[Dob] [date] NULL,
	[Phonenumber] [nvarchar](10) NULL,
	[Address] [nvarchar](100) NULL,
	[Email] [nvarchar](50) NOT NULL,
	[accStatus] [bit] NULL,
	[uImage] [nvarchar](300) NULL,
	[googleID] [nvarchar](50) NULL,
	[RememberMe] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Admins] ON 

INSERT [dbo].[Admins] ([AdminID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [TeacherDescription], [RoleA], [adminStatus], [aImage], [RememberMe]) VALUES (1, N'tuanvm', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'Vương Minh Tuấn', CAST(N'1980-05-10' AS Date), N'0284738195', N'al201r', N'tuanvm@gamil.com', N'', N'2', 1, N'ai.jpg', N'f32b93ef7c9478e8d8ca0fb5435fa3bc9e5f544b3b7c41241eb446322388e4eb')
INSERT [dbo].[Admins] ([AdminID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [TeacherDescription], [RoleA], [adminStatus], [aImage], [RememberMe]) VALUES (2, N'tientd', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'Tạ Đình Tiến', CAST(N'1985-06-15' AS Date), N'0933495894', N'sô 1 Chùa Láng', N'tientd@gamil.com', N'', N'1,2', 1, N'', NULL)
INSERT [dbo].[Admins] ([AdminID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [TeacherDescription], [RoleA], [adminStatus], [aImage], [RememberMe]) VALUES (3, N'khuongpd', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'Phùng Duy Khương', CAST(N'1982-02-18' AS Date), N'09353446', N'số 2 Nguyễn Trãi', N'khuongpd@gamil.com', N'', N'3', 1, N'', N'bdcd36a641d3d94e2632233a4b711bd0d2a39e11896a4b7836a7ae4ee5811dd5')
INSERT [dbo].[Admins] ([AdminID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [TeacherDescription], [RoleA], [adminStatus], [aImage], [RememberMe]) VALUES (4, N'namdd', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'Đinh Đại Nam', CAST(N'1982-02-18' AS Date), N'0366476002', N'Ninh Bình', N'nam10xgt@gmail.com', N'', N'1,2', 1, N'', NULL)
INSERT [dbo].[Admins] ([AdminID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [TeacherDescription], [RoleA], [adminStatus], [aImage], [RememberMe]) VALUES (5, N'nam1', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'Đinh Đại Nam', CAST(N'1982-02-18' AS Date), N'0366476002', N'Ninh Bình', N'namaaa10xgt@gmail.com', N'dadad12', N'1,2,3', 1, N'346756.png', N'c627be0c69e62ec5b699c03602605758aff0ee8c2211476b89768960e584e43f')
INSERT [dbo].[Admins] ([AdminID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [TeacherDescription], [RoleA], [adminStatus], [aImage], [RememberMe]) VALUES (6, N'namAdmin', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'Nam', CAST(N'2002-11-11' AS Date), N'0345454544', N'Ninh Binh', N'namssssssss10xgt@gmail.com', N'', N'4', 1, N'999252.png', N'd408674122a85a0fc2dded85f938463396b1c3e9fc1730705a628fd7e895fea8')
INSERT [dbo].[Admins] ([AdminID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [TeacherDescription], [RoleA], [adminStatus], [aImage], [RememberMe]) VALUES (11, N'namAdmindadad', N'176e70e29dd8668581237247c18521bf1ef5cfbe9f0f0fde6f8d8bf3af2a3fa6', N'Đinh Đại Nam', NULL, N'0906198348', NULL, N'dadadad@gmail.com', NULL, N'1', 0, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Admins] OFF
GO
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (1, 1)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (2, 1)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (3, 5)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (4, 4)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (5, 1)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (6, 2)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (7, 1)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (9, 3)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (10, 6)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (11, 3)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (8, 1)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (12, 1)
INSERT [dbo].[BookOfCourse] ([Course_BookID], [CourseID]) VALUES (13, 1)
GO
SET IDENTITY_INSERT [dbo].[Course] ON 

INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (1, N'Python', 150000, 1, N'Beginner course for Python      ', CAST(N'1905-06-29T00:00:00.000' AS DateTime), N'Python.png', 20, N'https://www.youtube.com/watch?v=NZj6LI5a9vc&list=PL33lvabfss1xczCv2BA0SaNJHu_VXsFtg', 1, 1)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (2, N'C', 200000, 1, N'Beginner course for C', CAST(N'1905-06-29T00:00:00.000' AS DateTime), N'C.jpg', 2000, N'https://www.youtube.com/watch?v=vpqMmfkSAMo&list=PLux-_phi0Rz2TB5D16sJzy3MgOht3IlND', 1, 2)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (3, N'C++', 200000, 1, N'Beginner course for C++', CAST(N'1905-06-29T00:00:00.000' AS DateTime), N'C++.jpg', 2200, N'https://www.youtube.com/watch?v=hu20Ld4Yf-A&list=PLux-_phi0Rz0Hq9fDP4TlOulBl8APKp79', 1, 3)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (4, N'C Sharp', 100000, 1, N'Beginner course for C#', CAST(N'1905-06-29T00:00:00.000' AS DateTime), N'Csharp.png', 2020, N'https://www.youtube.com/watch?v=9kohr6pMwag&list=PL33lvabfss1wUj15ea6W0A-TtDOrWWSRK', 1, 1)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (5, N'Java', 200000, 1, N'Beginner course for Java', CAST(N'1905-06-29T00:00:00.000' AS DateTime), N'Java.jpg', 2030, N'https://www.youtube.com/watch?v=3gtOAlcovoQ&list=PL33lvabfss1yGrOutFR03OZoqm91TSsvs', 1, 2)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (6, N'SQL', 250000, 1, N'Beginner course for SQL', CAST(N'1905-06-29T00:00:00.000' AS DateTime), N'SQL.jpg', 2040, N'https://www.youtube.com/watch?v=2fanjSYVElY&list=PL33lvabfss1xnFpWQF6YH11kMTS1HmLsw', 1, 1)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (7, N'HTML,CSS', 20000, 1, N'Beginner course for WEB', CAST(N'1905-06-29T00:00:00.000' AS DateTime), N'Web.jpg', 2050, N'https://www.youtube.com/watch?v=R6plN3FvzFY&list=PL_-VfJajZj0U9nEXa4qyfB4U5ZIYCMPlz', 0, 2)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (8, N'Test', 100000, 1, N'Test     ', CAST(N'2023-06-15T00:00:00.000' AS DateTime), N'test.png', 0, N'youtube', 0, 5)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (9, N'Nguyen Van A', 120000, 1, N'aaaaaaaaaaaaaa ', CAST(N'2023-06-26T00:00:00.000' AS DateTime), N'1314842.jpg', 0, N'ddddddddđ', 0, 2)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (10, N'HTML,CSSdadada', 1111111168, 1, N'dadad', CAST(N'2023-07-05T00:00:00.000' AS DateTime), N'999252.png', 0, N' dada', 0, 5)
INSERT [dbo].[Course] ([CourseID], [CourseName], [CoursePrice], [CoursePropose], [CourseDescription], [CourseCreateDate], [CourseImage], [NumberStudentEnrolled], [LinkCourse], [courseStatus], [adminID]) VALUES (11, N'test', 1.8999999358230856E+18, 1, N'dâdadad           ', CAST(N'2023-07-22T00:00:00.000' AS DateTime), N'ApproveCancelOrder.drawio (1).png', 0, N'', 1, 6)
SET IDENTITY_INSERT [dbo].[Course] OFF
GO
SET IDENTITY_INSERT [dbo].[Course_Book] ON 

INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (1, N'Python', 150, 0, N'<p><img src="uploads/c (2).jpg" alt="" width="225" height="225" /></p>
<p>&nbsp;</p>', 100, N'Đây là sách của Python')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (2, N'C Book', 350, 0, N'<p><img src="uploads/c (2).jpg" alt="" width="225" height="225" /></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>', 200, N'Đây là sách của C')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (3, N'Java Book', 35000, 1, N'<p><img src="uploads/Java.jpg" alt="" width="318" height="159" /></p>
<p>&nbsp;</p>
<p>&nbsp;</p>', 150, N'Đây là sách của java')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (4, N'C Sharp', 15000, 0, N'<p><img src="uploads/Csharp.png" alt="" width="300" height="168" /></p>', 150, N'Đây là sách của C Sharp')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (5, N'Python Advance', 140000, 1, N'<p><img src="uploads/Python.png" alt="" width="268" height="188" /></p>', 150, N'Đây là sách nâng cao của python')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (6, N'C Advance', 1500000, 1, N'<img class="img-fluid" src="img/course-1.jpg" alt="">', 150, N'Đây là sách hướng dẫn nâng cao của C')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (7, N'Python Advance', 2000000, 1, N'<p><img src="uploads/Python.png" alt="" width="268" height="188" /></p>', 150, N'Đây là sách nâng cao của python')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (8, N'Python Advance', 15000, 1, N'<img class="img-fluid" src="img/course-1.jpg" alt="">', 15, N'Đây là sách nâng cao của python')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (9, N'c++', 120, 1, N'<p><img src="uploads/C++.jpg" alt="" width="750" height="422" /></p>', 300, N'Đây là sách của C++')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (10, N'SQL Book', 123, 1, N'<p><img src="uploads/homepage2.jpg" alt="" width="300" height="168" /></p>', 12, N'this is a test book ')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (11, N'aaaaaaaa', 15, 0, N'<p><img src="uploads/362464809_266784535983824_5481825066602344732_n.png" alt="" width="1175" height="673" /></p>', 12, N'#test2')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (12, N'py', 123.124, 0, N'<p><img src="uploads/usecase.drawio (8).png" alt="" width="400" height="199" /></p>', 12, N'100')
INSERT [dbo].[Course_Book] ([Course_BookID], [BookName], [Price], [Bookstatus], [BookImg], [StockQuantity], [bDescription]) VALUES (13, N'py', 123322, 0, N'<p><img src="uploads/usecase.drawio (8).png" alt="" width="200" height="100" /></p>', 12, N'this is a test book ')
SET IDENTITY_INSERT [dbo].[Course_Book] OFF
GO
SET IDENTITY_INSERT [dbo].[Course_Category] ON 

INSERT [dbo].[Course_Category] ([Course_CategoryID], [Course_CategoryName], [Course_CategoryImg]) VALUES (1, N'Free', NULL)
INSERT [dbo].[Course_Category] ([Course_CategoryID], [Course_CategoryName], [Course_CategoryImg]) VALUES (2, N'Have Cost', NULL)
INSERT [dbo].[Course_Category] ([Course_CategoryID], [Course_CategoryName], [Course_CategoryImg]) VALUES (3, N'Web Programing Course', NULL)
INSERT [dbo].[Course_Category] ([Course_CategoryID], [Course_CategoryName], [Course_CategoryImg]) VALUES (4, N'Basic programming course', NULL)
SET IDENTITY_INSERT [dbo].[Course_Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Course_Document] ON 

INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (1, N'Bai 1 C Sharp', N'Assignment DBI.docx', 0, 1)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (2, N'Bai 2 C Sharp', N'C2.docx', 0, 2)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (3, N'Bai 3 C Sharp', N'C3.docx', 0, 3)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (4, N'Bai 4 C Sharp', N'C4.docx', 0, 4)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (5, N'Bai 5 C Sharp', N'C5.docx', 0, 5)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (6, N'dadad', N'C2.docx', 0, 2)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (7, N'Laptop Acerdada', N'C2 (1).docx', 0, 2)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (8, N'Nguyen Van A', N'Name.docx', 1, 1)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (9, N'bai', N'SDS_n.docx', 1, 19)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (10, N'HTML,CSS', N'SDS_n.docx', 1, 19)
INSERT [dbo].[Course_Document] ([Course_DocumentID], [DocumentName], [DocumentLink], [status], [CourseVideoID]) VALUES (11, N'', N'editSDS (4).docx', 1, 23)
SET IDENTITY_INSERT [dbo].[Course_Document] OFF
GO
SET IDENTITY_INSERT [dbo].[Course_Process] ON 

INSERT [dbo].[Course_Process] ([Course_ProcessID], [Course_ProcessName], [Course_ProcessImage], [cpStatus]) VALUES (1, N'Learning Web from basic to pro', N'Web.jpg', 1)
INSERT [dbo].[Course_Process] ([Course_ProcessID], [Course_ProcessName], [Course_ProcessImage], [cpStatus]) VALUES (2, N'Learning Python from basic to pro', N'Python.png', 1)
INSERT [dbo].[Course_Process] ([Course_ProcessID], [Course_ProcessName], [Course_ProcessImage], [cpStatus]) VALUES (3, N'Learning C# from basic to pro', N'Csharp.png', 1)
INSERT [dbo].[Course_Process] ([Course_ProcessID], [Course_ProcessName], [Course_ProcessImage], [cpStatus]) VALUES (4, N'Learning Java from basic to ', N'ApproveCancelOrder.drawio (1).png', 1)
INSERT [dbo].[Course_Process] ([Course_ProcessID], [Course_ProcessName], [Course_ProcessImage], [cpStatus]) VALUES (5, N'fsfsfs', N'RegisterSequence.drawio.png', 0)
SET IDENTITY_INSERT [dbo].[Course_Process] OFF
GO
SET IDENTITY_INSERT [dbo].[CourseVideo] ON 

INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (1, N'Bài 1: C Sharp là gì', 1, N'https://www.youtube.com/embed/9kohr6pMwag', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (2, N'Bài 2: Cấu trúc lệnh cơ bản', 2, N'https://www.youtube.com/embed/FhAIc0tlyaQ', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (3, N'Bài 3: Nhập xuất cơ bản', 3, N'https://www.youtube.com/embed/BAscPWPtCD8', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (4, N'Bài 4: Biến trong C# ', 4, N'https://www.youtube.com/embed/IEz7uMSHitM', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (5, N'Bài 5: Kiểu dữ liệu trong C# ', 5, N'https://www.youtube.com/embed/yrH7Qe8FXqE', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (6, N'Bài 6: Toán tử trong C#', 6, N'https://www.youtube.com/embed/niz7Gg8uB-k', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (7, N'Bài 7: Hằng', 7, N'https://www.youtube.com/embed/13NRSYgKh0o', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (8, N'Bài 8: Ép kiểu trong C#', 8, N'https://www.youtube.com/embed/YmF2kTg0ajU', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (13, N'Bài 9: If else trong C#', 9, N'https://www.youtube.com/embed/O3ijcGpEgSY', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (14, N'Bài 10: Switch case trong C# ', 10, N'https://www.youtube.com/embed/0NYj4QkJx4U', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (17, N'Bài 11: Kiểu dữ liệu object và từ khóa var', 11, N'https://www.youtube.com/embed/SkxQlfdhVko', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (18, N'Bài 12: Kiểu dữ liệu dynamic', 12, N'https://www.youtube.com/embed/lM-7tv768XA', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (19, N'Bài 1: Giới thiệu ngôn ngữ lập trình Python', 1, N'https://www.youtube.com/embed/NZj6LI5a9vc', 1, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (23, N'Bài 13: Giới thiệu cấu trúc lặp', 13, N'https://www.youtube.com/embed/mKLRETK9slQ', 4, 1)
INSERT [dbo].[CourseVideo] ([CourseVideoID], [VideoName], [VideoOrder], [VideoLink], [CourseID], [status]) VALUES (24, N'Bài 15: Vòng lặp For | HowKteam', 14, N'https://www.youtube.com/embed/QW-1sWoK3Bo', 4, 0)
SET IDENTITY_INSERT [dbo].[CourseVideo] OFF
GO
SET IDENTITY_INSERT [dbo].[Discount] ON 

INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (1, 50, CAST(N'2023-06-15T14:41:45.167' AS DateTime), 5, 1, 1)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (2, 30, CAST(N'2023-05-13T00:00:00.000' AS DateTime), 1, 2, 1)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (3, 30, CAST(N'2023-05-13T00:00:00.000' AS DateTime), 1, 3, 1)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (4, 20, CAST(N'2023-05-13T00:00:00.000' AS DateTime), 2, 4, 0)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (5, 40, CAST(N'2023-06-15T14:36:14.763' AS DateTime), 1, 5, 1)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (6, 20, CAST(N'2023-05-13T00:00:00.000' AS DateTime), 2, 6, 0)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (7, 20, CAST(N'2023-05-13T00:00:00.000' AS DateTime), 2, 7, 0)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (8, 10, CAST(N'2023-06-15T14:41:54.863' AS DateTime), 5, 8, 1)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (9, 50, CAST(N'2023-06-26T21:52:09.763' AS DateTime), 2, 9, 1)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (10, 0, CAST(N'2023-07-05T16:24:50.730' AS DateTime), 1, 10, 1)
INSERT [dbo].[Discount] ([DiscountID], [Discount], [CreateDiscountDate], [AdminID], [CourseID], [discountStatus]) VALUES (11, 50, CAST(N'2023-07-22T23:07:50.243' AS DateTime), 6, 11, 1)
SET IDENTITY_INSERT [dbo].[Discount] OFF
GO
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (1, 2)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (1, 4)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (2, 2)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (2, 4)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (3, 2)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (3, 4)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (4, 2)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (4, 4)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (5, 2)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (5, 4)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (6, 2)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (7, 2)
INSERT [dbo].[hasCategory] ([CourseID], [Course_CategoryID]) VALUES (7, 3)
GO
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (1, 1)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (1, 3)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (1, 4)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (1, 5)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (2, 1)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (2, 3)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (2, 4)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (2, 5)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (3, 1)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (3, 4)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (3, 5)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (4, 5)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (5, 1)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (6, 1)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (6, 3)
INSERT [dbo].[include] ([CourseID], [Course_ProcessID]) VALUES (7, 1)
GO
SET IDENTITY_INSERT [dbo].[News] ON 

INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (1, CAST(N'2023-07-26T12:31:00.000' AS DateTime), N'Đợi đấu thầu sân bay Long Thành, Coteccons và Ricons đưa nhau ra tòa', N'<h2 class="singular-sapo" style="box-sizing: border-box; margin: 32px 0px 0px; font-size: 18px; line-height: 30px; color: #333333; font-style: italic; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-weight: 400;">(D&acirc;n tr&iacute;) - Cho rằng Thủ đ&ocirc; cần được giao quyền quyết định đầu tư c&ocirc;ng c&aacute;c dự &aacute;n quy m&ocirc; lớn, B&iacute; thư H&agrave; Nội đề xuất d&agrave;nh ri&ecirc;ng một g&oacute;i vay ODA cho 10 tuyến đường sắt tr&ecirc;n địa b&agrave;n th&agrave;nh phố.</h2>
<div class="singular-content" style="box-sizing: border-box; margin: 32px 0px 0px; font-size: 18px; line-height: 30px; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; color: #333333;">
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Nội dung n&agrave;y được B&iacute; thư Th&agrave;nh ủy H&agrave; Nội Đinh Tiến Dũng đề xuất chiều 25/7, tại buổi l&agrave;m việc của Chủ tịch Quốc hội Vương Đ&igrave;nh Huệ với Ban Thường vụ Th&agrave;nh ủy H&agrave; Nội. Nội dung cuộc l&agrave;m việc về thực hiện một số Nghị quyết của Quốc hội v&agrave; x&acirc;y dựng Dự &aacute;n Luật Thủ đ&ocirc; (sửa đổi).&nbsp;</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Cụ thể, &ocirc;ng Dũng cho rằng đối với nhu cầu x&acirc;y dựng 10 tuyến đường sắt tr&ecirc;n địa b&agrave;n H&agrave; Nội, nếu thực hiện theo quy tr&igrave;nh, c&aacute;ch thức hiện nay sẽ manh m&uacute;n v&agrave; k&eacute;o d&agrave;i. Do đ&oacute;, &ocirc;ng đề xuất cơ chế d&agrave;nh ri&ecirc;ng một g&oacute;i vay ODA d&agrave;nh cho cả 10 tuyến để thực hiện đồng bộ, bảo đảm kỹ thuật v&agrave; thời gian vận h&agrave;nh...</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Theo B&iacute; thư H&agrave; Nội, nội dung cuộc l&agrave;m việc đều l&agrave; những h&agrave;nh lang ph&aacute;p l&yacute; quan trọng để H&agrave; Nội c&oacute; điều kiện ph&aacute;t triển bứt ph&aacute;, g&oacute;p phần hiện thực h&oacute;a mục ti&ecirc;u Nghị quyết số 15 của Bộ Ch&iacute;nh trị.&nbsp;</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">&Ocirc;ng Dũng khẳng định th&agrave;nh phố tiếp thu đầy đủ, nghi&ecirc;m t&uacute;c c&aacute;c &yacute; kiến trao đổi, g&oacute;p &yacute; của Quốc hội, Ủy ban của Quốc hội v&agrave; c&aacute;c bộ, ng&agrave;nh Trung ương; đặc biệt l&agrave; tiếp thu chỉ đạo của Chủ tịch Quốc hội để tổ chức triển khai thực hiện, ho&agrave;n th&agrave;nh c&aacute;c b&aacute;o c&aacute;o.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Trong đ&oacute;, th&agrave;nh phố sẽ ho&agrave;n thiện hồ sơ, tr&igrave;nh Quốc hội 3 nội dung c&oacute; t&iacute;nh chiến lược v&agrave;o kỳ họp th&aacute;ng 10 tới gồm: Luật Thủ đ&ocirc; (sửa đổi); Đồ &aacute;n điều chỉnh tổng thể Quy hoạch chung x&acirc;y dựng thủ đ&ocirc; H&agrave; Nội đến năm 2030, tầm nh&igrave;n đến năm 2050; Quy hoạch thủ đ&ocirc; H&agrave; Nội thời kỳ 2021-2030, tầm nh&igrave;n đến năm 2050.&nbsp;</p>
</div>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 6, 0, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (2, CAST(N'2023-06-14T11:48:07.000' AS DateTime), N'hot news', N'<p>"Hai nh&agrave; l&atilde;nh đạo sẽ hợp t&aacute;c để x&acirc;y dựng li&ecirc;n minh quốc tế nhằm tiếp tục gi&uacute;p Ukraine n&acirc;ng cao khả năng chiến đấu, hỗ trợ mọi hoạt động từ huấn luyện tới mua ti&ecirc;m k&iacute;ch F-16. Thủ tướng (Sunak) nhấn mạnh, &ocirc;ng tin rằng vị tr&iacute; xứng đ&aacute;ng của Ukraine l&agrave; ở NATO v&agrave; c&aacute;c nh&agrave; l&atilde;nh đạo đ&atilde; nhất tr&iacute; về tầm quan trọng của việc c&aacute;c đồng minh cung cấp hỗ trợ an ninh l&acirc;u d&agrave;i cho Ukraine để đảm bảo Kiev c&oacute; thể ngăn chặn c&aacute;c cuộc tấn c&ocirc;ng trong tương lai", th&ocirc;ng b&aacute;o của văn ph&ograve;ng thủ tướng Anh cho biết. Th&ocirc;ng b&aacute;o ng&agrave;y 16/5 được c&ocirc;ng bố một ng&agrave;y sau khi Tổng thống Ukraine Volodymyr Zelensky n&oacute;i rằng, Kiev c&oacute; thể sớm nhận được m&aacute;y bay chiến đấu F-16. &Ocirc;ng hy vọng sẽ c&oacute; "những quyết định rất quan trọng" về vấn đề n&agrave;y được đưa ra với sự gi&uacute;p đỡ của Vương quốc Anh.</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 3, 1, 2)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (3, CAST(N'2023-07-12T05:12:35.000' AS DateTime), N'information', N'<p>Tại cuộc họp, Anh cũng cam kết cung cấp "h&agrave;ng trăm m&aacute;y bay kh&ocirc;ng người l&aacute;i tấn c&ocirc;ng" cho Ukraine. Hồi th&aacute;ng 2, Anh cho biết, họ sẽ bắt đầu đ&agrave;o tạo phi c&ocirc;ng Ukraine theo c&aacute;c kỹ thuật ti&ecirc;u chuẩn của NATO. V&agrave;o ng&agrave;y 15/5, Anh đ&atilde; nhắc lại việc n&agrave;y, nhấn mạnh đ&acirc;y l&agrave; kế hoạch n&agrave;y l&agrave; gi&uacute;p "x&acirc;y dựng một lực lượng kh&ocirc;ng qu&acirc;n mới của Ukraine với c&aacute;c m&aacute;y bay phản lực F-16 ti&ecirc;u chuẩn của NATO". Anh kh&ocirc;ng sở hữu ti&ecirc;m k&iacute;ch F-16 do nh&agrave; thầu Mỹ Lockheed Martin ở South Carolina sản xuất. Trong thời gian qua, Ukraine nhiều lần k&ecirc;u gọi Mỹ viện trợ F-16, nhưng Washington chưa chấp thuận đề xuất n&agrave;y. Khi được hỏi h&ocirc;m 15/5 rằng liệu Mỹ c&oacute; thay đổi quan điểm về việc cung cấp m&aacute;y bay phản lực cho Ukraine hay kh&ocirc;ng, John Kirby, ph&aacute;t ng&ocirc;n vi&ecirc;n của Hội đồng an ninh quốc gia của Nh&agrave; Trắng, đ&atilde; trả lời l&agrave;: "Kh&ocirc;ng".</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 1, 0, 2)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (4, CAST(N'2023-06-15T01:38:28.000' AS DateTime), N'Test', N'<p>"Hai nh&agrave; l&atilde;nh đạo sẽ hợp t&aacute;c để x&acirc;y dựng li&ecirc;n minh quốc tế nhằm tiếp tục gi&uacute;p Ukraine n&acirc;ng cao khả năng chiến đấu, hỗ trợ mọi hoạt động từ huấn luyện tới mua ti&ecirc;m k&iacute;ch F-16. Thủ tướng (Sunak) nhấn mạnh, &ocirc;ng tin rằng vị tr&iacute; xứng đ&aacute;ng của Ukraine l&agrave; ở NATO v&agrave; c&aacute;c nh&agrave; l&atilde;nh đạo đ&atilde; nhất tr&iacute; về tầm quan trọng của việc c&aacute;c đồng minh cung cấp hỗ trợ an ninh l&acirc;u d&agrave;i cho Ukraine để đảm bảo Kiev c&oacute; thể ngăn chặn c&aacute;c cuộc tấn c&ocirc;ng trong tương lai", th&ocirc;ng b&aacute;o của văn ph&ograve;ng thủ tướng Anh cho biết. Th&ocirc;ng b&aacute;o ng&agrave;y 16/5 được c&ocirc;ng bố một ng&agrave;y sau khi Tổng thống Ukraine Volodymyr Zelensky n&oacute;i rằng, Kiev c&oacute; thể sớm nhận được m&aacute;y bay chiến đấu F-16. &Ocirc;ng hy vọng sẽ c&oacute; "những quyết định rất quan trọng" về vấn đề n&agrave;y được đưa ra với sự gi&uacute;p đỡ của Vương quốc Anh.</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 1, 1, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (5, CAST(N'2023-06-14T11:47:21.000' AS DateTime), N'Test', N'<p>"Hai nh&agrave; l&atilde;nh đạo sẽ hợp t&aacute;c để x&acirc;y dựng li&ecirc;n minh quốc tế nhằm tiếp tục gi&uacute;p Ukraine n&acirc;ng cao khả năng chiến đấu, hỗ trợ mọi hoạt động từ huấn luyện tới mua ti&ecirc;m k&iacute;ch F-16. Thủ tướng (Sunak) nhấn mạnh, &ocirc;ng tin rằng vị tr&iacute; xứng đ&aacute;ng của Ukraine l&agrave; ở NATO v&agrave; c&aacute;c nh&agrave; l&atilde;nh đạo đ&atilde; nhất tr&iacute; về tầm quan trọng của việc c&aacute;c đồng minh cung cấp hỗ trợ an ninh l&acirc;u d&agrave;i cho Ukraine để đảm bảo Kiev c&oacute; thể ngăn chặn c&aacute;c cuộc tấn c&ocirc;ng trong tương lai", th&ocirc;ng b&aacute;o của văn ph&ograve;ng thủ tướng Anh cho biết. Th&ocirc;ng b&aacute;o ng&agrave;y 16/5 được c&ocirc;ng bố một ng&agrave;y sau khi Tổng thống Ukraine Volodymyr Zelensky n&oacute;i rằng, Kiev c&oacute; thể sớm nhận được m&aacute;y bay chiến đấu F-16. &Ocirc;ng hy vọng sẽ c&oacute; "những quyết định rất quan trọng" về vấn đề n&agrave;y được đưa ra với sự gi&uacute;p đỡ của Vương quốc Anh.</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 1, 1, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (6, CAST(N'2023-06-15T03:52:04.000' AS DateTime), N'Test', N'<p>"Hai nh&agrave; l&atilde;nh đạo sẽ hợp t&aacute;c để x&acirc;y dựng li&ecirc;n minh quốc tế nhằm tiếp tục gi&uacute;p Ukraine n&acirc;ng cao khả năng chiến đấu, hỗ trợ mọi hoạt động từ huấn luyện tới mua ti&ecirc;m k&iacute;ch F-16. Thủ tướng (Sunak) nhấn mạnh, &ocirc;ng tin rằng vị tr&iacute; xứng đ&aacute;ng của Ukraine l&agrave; ở NATO v&agrave; c&aacute;c nh&agrave; l&atilde;nh đạo đ&atilde; nhất tr&iacute; về tầm quan trọng của việc c&aacute;c đồng minh cung cấp hỗ trợ an ninh l&acirc;u d&agrave;i cho Ukraine để đảm bảo Kiev c&oacute; thể ngăn chặn c&aacute;c cuộc tấn c&ocirc;ng trong tương lai", th&ocirc;ng b&aacute;o của văn ph&ograve;ng thủ tướng Anh cho biết. Th&ocirc;ng b&aacute;o ng&agrave;y 16/5 được c&ocirc;ng bố một ng&agrave;y sau khi Tổng thống Ukraine Volodymyr Zelensky n&oacute;i rằng, Kiev c&oacute; thể sớm nhận được m&aacute;y bay chiến đấu F-16. &Ocirc;ng hy vọng sẽ c&oacute; "những quyết định rất quan trọng" về vấn đề n&agrave;y được đưa ra với sự gi&uacute;p đỡ của Vương quốc Anh.</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 1, 1, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (7, CAST(N'2023-06-25T10:43:04.000' AS DateTime), N'Test', N'<p>"Hai nh&agrave; l&atilde;nh đạo sẽ hợp t&aacute;c để x&acirc;y dựng li&ecirc;n minh quốc tế nhằm tiếp tục gi&uacute;p Ukraine n&acirc;ng cao khả năng chiến đấu, hỗ trợ mọi hoạt động từ huấn luyện tới mua ti&ecirc;m k&iacute;ch F-16. Thủ tướng (Sunak) nhấn mạnh, &ocirc;ng tin rằng vị tr&iacute; xứng đ&aacute;ng của Ukraine l&agrave; ở NATO v&agrave; c&aacute;c nh&agrave; l&atilde;nh đạo đ&atilde; nhất tr&iacute; về tầm quan trọng của việc c&aacute;c đồng minh cung cấp hỗ trợ an ninh l&acirc;u d&agrave;i cho Ukraine để đảm bảo Kiev c&oacute; thể ngăn chặn c&aacute;c cuộc tấn c&ocirc;ng trong tương lai", th&ocirc;ng b&aacute;o của văn ph&ograve;ng thủ tướng Anh cho biết. Th&ocirc;ng b&aacute;o ng&agrave;y 16/5 được c&ocirc;ng bố một ng&agrave;y sau khi Tổng thống Ukraine Volodymyr Zelensky n&oacute;i rằng, Kiev c&oacute; thể sớm nhận được m&aacute;y bay chiến đấu F-16. &Ocirc;ng hy vọng sẽ c&oacute; "những quyết định rất quan trọng" về vấn đề n&agrave;y được đưa ra với sự gi&uacute;p đỡ của Vương quốc Anh.</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 1, 0, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (8, CAST(N'2023-06-25T10:26:37.000' AS DateTime), N'Test', N'<p>&Ocirc;ng Indra Sjafri b&igrave;nh luận: "c, kh&ocirc;ng chỉ thể hiện qua những b&agrave;n thắng. T&ocirc;i ra hiệu cho c&aacute;c cầu thủ của t&ocirc;i phải dừng m&agrave;n ẩu đả lại, nhưng hầu như mọi cầu thủ Th&aacute;i Lan đều kh&ocirc;ng giữ được b&igrave;nh tĩnh". "Họ như những mảnh vụn chỉ chờ lao v&agrave;o ch&uacute;ng t&ocirc;i, mấu chốt của vấn đề nằm ở chỗ ph&iacute;a Th&aacute;i Lan kh&ocirc;ng giữ được b&igrave;nh tĩnh trước. Tuy nhi&ecirc;n, mọi việc n&ecirc;n kết th&uacute;c ở đ&acirc;y, những g&igrave; diễn ra một lần nữa phản &aacute;nh trong b&oacute;ng đ&aacute; c&oacute; những điều kh&ocirc;ng thể l&yacute; giải v&agrave; kh&ocirc;ng thể lường trước. Sau trận đấu đ&ocirc;i b&ecirc;n đ&atilde; giảng h&ograve;a" - HLV Indra Sjafri quả quyết. HLV Indra Sjafri cũng khẳng định đội U22 Indonesia l&agrave; đội chơi tốt hơn trong trận chung kết, xứng đ&aacute;ng c&oacute; chiến thắng.<img src="uploads/348267.png" alt="" width="512" height="512" /></p>
<p><img src="uploads/346756.png" alt="" width="512" height="512" /></p>
<p><img src="uploads/w3logo.jfif" alt="" width="104" height="142" /></p>
<p>&nbsp;</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 1, 0, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (9, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'123 Street, New York, USA', N'0366476002', N'nam10xgt@gmail.com', 1, 0, 3)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (10, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'HOME', N'homePage', NULL, NULL, 1, 4)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (11, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'COURSE', N'displayCourse', NULL, NULL, 1, 4)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (12, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'BOOK OF COURSE', N'clientbookcourse', NULL, NULL, 1, 4)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (13, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'PROCESS COURSE', N'learningPath', NULL, NULL, 1, 4)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (14, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'OWN COURSE', N'purchasedCourse', NULL, NULL, 1, 4)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (17, CAST(N'2023-06-27T04:47:27.000' AS DateTime), N'check', N'<h2 class="singular-sapo" style="box-sizing: border-box; margin: 32px 0px 0px; font-size: 18px; line-height: 30px; color: #333333; font-style: italic; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-weight: 400;">(D&acirc;n tr&iacute;) - Suy giảm kinh tế, lạm ph&aacute;t gia tăng, hậu quả của đại dịch Covid-19, cạnh tranh chiến lược giữa c&aacute;c quốc gia&hellip; l&agrave; những "cơn gi&oacute; ngược" đang cản trở sự tăng trưởng, theo Thủ tướng Phạm Minh Ch&iacute;nh.</h2>
<div class="singular-content" style="box-sizing: border-box; margin: 32px 0px 0px; font-size: 18px; line-height: 30px; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; color: #333333;">
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Nội dung n&agrave;y được Thủ tướng Phạm Minh Ch&iacute;nh chia sẻ khi ph&aacute;t biểu tại phi&ecirc;n thảo luận đầu ti&ecirc;n của Hội nghị Diễn đ&agrave;n kinh tế thế giới c&aacute;c nh&agrave; ti&ecirc;n phong tại Thi&ecirc;n T&acirc;n (Trung Quốc), s&aacute;ng 27/6.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;"><strong style="box-sizing: border-box;">6 "cơn gi&oacute; ngược"</strong></p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Phi&ecirc;n thảo luận với chủ đề "Đương đầu với c&aacute;c cơn gi&oacute; ngược: Khởi động lại tăng trưởng trong bối cảnh mong manh" c&oacute; sự tham gia của hơn 300 đại biểu l&agrave; l&atilde;nh đạo c&aacute;c nước, tổ chức quốc tế v&agrave; đại diện c&aacute;c tập đo&agrave;n, doanh nghiệp lớn tr&ecirc;n thế giới.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Với việc WEF lựa chọn th&agrave;nh phố Thi&ecirc;n T&acirc;n, Trung Quốc l&agrave; địa điểm tổ chức Hội nghị, Thủ tướng Phạm Minh Ch&iacute;nh nhấn mạnh vai tr&ograve; quan trọng của Trung Quốc trong nền kinh tế to&agrave;n cầu.</p>
<figure class="image align-center" style="box-sizing: border-box; margin-top: 28px; margin-bottom: 28px; padding: 0px; float: none;"><img class="entered loaded" style="box-sizing: border-box; max-width: 100%; height: auto; width: 680px; cursor: zoom-in;" title="Thủ tướng Phạm Minh Ch&iacute;nh: 6 cơn gi&oacute; ngược cản trở tăng trưởng kinh tế - 1" src="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg" srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg 2x" alt="Thủ tướng Phạm Minh Ch&iacute;nh: 6 cơn gi&oacute; ngược cản trở tăng trưởng kinh tế - 1" data-width="1562" data-height="1041" data-original="https://icdn.dantri.com.vn/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg" data-photo-id="2523770" data-track-content="" data-content-name="article-content-image" data-content-piece="article-content-image_2523770" data-content-target="/xa-hoi/thu-tuong-pham-minh-chinh-6-con-gio-nguoc-can-tro-tang-truong-kinh-te-20230627072157879.htm" data-src="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg" data-srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/06/27/pham-minh-chinh-edited-1687848916900.jpeg 2x" data-ll-status="loaded" />
<figcaption style="box-sizing: border-box; margin: 8px 0px 0px; padding: 0px 30px; font-size: 14px; line-height: 22px; font-style: italic; color: #666666;">
<p style="box-sizing: border-box; margin: 0px;">Thủ tướng Phạm Minh Ch&iacute;nh ph&aacute;t biểu tại phi&ecirc;n thảo luận đầu ti&ecirc;n của Hội nghị Diễn đ&agrave;n kinh tế thế giới c&aacute;c nh&agrave; ti&ecirc;n phong tại Thi&ecirc;n T&acirc;n, Trung Quốc (Ảnh: Đo&agrave;n Bắc).</p>
</figcaption>
</figure>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Người đứng đầu Ch&iacute;nh phủ Việt Nam chia sẻ 6 "cơn gi&oacute; ngược" đang cản trở sự tăng trưởng của kinh tế thế giới v&agrave; Việt Nam.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Một l&agrave; suy giảm kinh tế to&agrave;n cầu, lạm ph&aacute;t gia tăng, đời sống người d&acirc;n gặp nhiều kh&oacute; khăn. Hai l&agrave; hậu quả của đại dịch Covid-19 đối với nền kinh tế thế giới v&agrave; c&aacute;c nước c&ograve;n k&eacute;o d&agrave;i. Ba l&agrave; cạnh tranh địa chiến lược, chủ nghĩa bảo hộ, sự ph&acirc;n t&aacute;ch, ph&acirc;n mảnh, thiếu sự li&ecirc;n kết chặt chẽ giữa c&aacute;c quốc gia.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Bốn l&agrave; c&aacute;c cuộc xung đột, trong đ&oacute; c&oacute; cuộc xung đột ở Ukraine đe dọa an ninh lương thực, năng lượng to&agrave;n cầu. Năm l&agrave; c&aacute;c nước đang ph&aacute;t triển chịu t&aacute;c động nặng nề nhất, c&oacute; khả năng hạn chế trong th&iacute;ch ứng v&agrave; sức chống chịu trước những c&uacute; sốc từ b&ecirc;n ngo&agrave;i. S&aacute;u l&agrave; biến đổi kh&iacute; hậu, thi&ecirc;n tai, dịch bệnh ng&agrave;y c&agrave;ng diễn biến phức tạp, kh&oacute; lường.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Để đương đầu với c&aacute;c "cơn gi&oacute; ngược", Thủ tướng Phạm Minh Ch&iacute;nh đưa ra c&aacute;ch tiếp cận v&agrave; s&aacute;u định hướng quan trọng.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">"Đ&acirc;y l&agrave; những vấn đề mang t&iacute;nh to&agrave;n cầu, ảnh hưởng đến người d&acirc;n n&ecirc;n cần c&oacute; c&aacute;ch tiếp cận to&agrave;n cầu, to&agrave;n d&acirc;n", Thủ tướng Phạm Minh Ch&iacute;nh gợi mở 6 định hướng quan trọng để đối mặt với 6 "cơn gi&oacute; ngược".</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;"><strong style="box-sizing: border-box;">Việt Nam kh&ocirc;ng hy sinh m&ocirc;i trường để chạy theo tăng trưởng</strong></p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Thứ nhất, cần tăng cường đo&agrave;n kết quốc tế, đề cao chủ nghĩa đa phương; đặt người d&acirc;n vừa l&agrave; chủ thể, vừa l&agrave; trung t&acirc;m, l&agrave; nguồn lực vừa động lực cho ph&aacute;t triển.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Thứ hai, cần tập trung phục hồi sản xuất kinh doanh, tạo c&ocirc;ng ăn việc l&agrave;m, th&uacute;c đẩy thương mại, đầu tư, tạo ra d&ograve;ng vốn, thị trường, sản phẩm. Theo đ&oacute;, c&aacute;c tổ chức quốc tế, c&aacute;c định chế t&agrave;i ch&iacute;nh quốc tế, c&aacute;c nước lớn cần c&oacute; ch&iacute;nh s&aacute;ch khơi th&ocirc;ng nguồn lực, k&iacute;ch hoạt c&aacute;c động lực tăng trưởng mới về chuyển đổi số, tăng trưởng xanh, kinh tế tuần ho&agrave;n.</p>
<figure class="image align-center" style="box-sizing: border-box; margin-top: 28px; margin-bottom: 28px; padding: 0px; float: none;"><img class="entered loaded" style="box-sizing: border-box; max-width: 100%; height: auto; width: 680px; cursor: zoom-in;" title="Thủ tướng Phạm Minh Ch&iacute;nh: 6 cơn gi&oacute; ngược cản trở tăng trưởng kinh tế - 2" src="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/khai-mac-1687848875724.jpg" srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/khai-mac-1687848875724.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/06/27/khai-mac-1687848875724.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/06/27/khai-mac-1687848875724.jpg 2x" alt="Thủ tướng Phạm Minh Ch&iacute;nh: 6 cơn gi&oacute; ngược cản trở tăng trưởng kinh tế - 2" data-width="2200" data-height="1466" data-original="https://icdn.dantri.com.vn/2023/06/27/khai-mac-1687848875724.jpg" data-photo-id="2523767" data-track-content="" data-content-name="article-content-image" data-content-piece="article-content-image_2523767" data-content-target="/xa-hoi/thu-tuong-pham-minh-chinh-6-con-gio-nguoc-can-tro-tang-truong-kinh-te-20230627072157879.htm" data-src="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/khai-mac-1687848875724.jpg" data-srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/khai-mac-1687848875724.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/06/27/khai-mac-1687848875724.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/06/27/khai-mac-1687848875724.jpg 2x" data-ll-status="loaded" />
<figcaption style="box-sizing: border-box; margin: 8px 0px 0px; padding: 0px 30px; font-size: 14px; line-height: 22px; font-style: italic; color: #666666;">
<p style="box-sizing: border-box; margin: 0px;">Thủ tướng Phạm Minh Ch&iacute;nh chia sẻ b&agrave;i học kinh nghiệm của Việt Nam trong chống dịch v&agrave; phục hồi, tăng trưởng kinh tế (Ảnh: Đo&agrave;n Bắc).</p>
</figcaption>
</figure>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Thứ ba, cần giải ph&aacute;p ph&ugrave; hợp th&uacute;c đẩy tổng cung v&agrave; tổng cầu th&ocirc;ng qua c&aacute;c ch&iacute;nh s&aacute;ch tiền tệ, t&agrave;i kh&oacute;a, th&uacute;c đẩy tự do h&oacute;a thương mại, đầu tư, giảm gi&aacute; năng lượng, lương thực.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Thứ tư, kh&ocirc;ng ch&iacute;nh trị h&oacute;a c&aacute;c quan hệ kinh tế, giảm thiểu c&aacute;c yếu tố cản trở sự ph&aacute;t triển của to&agrave;n cầu. Thứ năm, sớm t&igrave;m giải ph&aacute;p giải quyết c&aacute;c cuộc xung đột. Thứ s&aacute;u, tăng cường hợp t&aacute;c c&ocirc;ng - tư, tạo điều kiện thuận lợi cho doanh nghiệp, đặc biệt l&agrave; c&aacute;c doanh nghiệp vừa v&agrave; nhỏ.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Chia sẻ b&agrave;i học kinh nghiệm của Việt Nam trong chống dịch v&agrave; phục hồi, tăng trưởng kinh tế, Thủ tướng cho biết Việt Nam đang tập trung triển khai ba đột ph&aacute; chiến lược về hạ tầng - thể chế - nh&acirc;n lực.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">"Quan điểm xuy&ecirc;n suốt của Việt Nam l&agrave; kh&ocirc;ng hy sinh c&ocirc;ng bằng, an sinh x&atilde; hội, bảo vệ m&ocirc;i trường để chạy theo tăng trưởng đơn thuần", Thủ tướng nhấn mạnh.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">&Ocirc;ng đồng thời cam kết Việt Nam sẽ tiếp tục tạo điều kiện thuận lợi nhất cho c&aacute;c doanh nghiệp quốc tế, trong nước, tiếp tục cải thiện m&ocirc;i trường đầu tư kinh doanh.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Thủ tướng đề nghị c&aacute;c nước, c&aacute;c tổ chức quốc tế, trong đ&oacute; c&oacute; WEF v&agrave; c&aacute;c th&agrave;nh vi&ecirc;n của WEF tiếp tục hợp t&aacute;c, hỗ trợ Việt Nam về c&ocirc;ng nghệ, t&agrave;i ch&iacute;nh, đ&agrave;o tạo nguồn nh&acirc;n lực v&agrave; kinh nghiệm quản trị hiện đại, gi&uacute;p Việt Nam tiếp tục thực hiện c&aacute;c mục ti&ecirc;u ph&aacute;t triển kinh tế - x&atilde; hội đ&atilde; đề ra.</p>
<figure class="image align-center" style="box-sizing: border-box; margin-top: 28px; margin-bottom: 28px; padding: 0px; float: none;"><img class="entered loaded" style="box-sizing: border-box; max-width: 100%; height: auto; width: 680px; cursor: zoom-in;" title="Thủ tướng Phạm Minh Ch&iacute;nh: 6 cơn gi&oacute; ngược cản trở tăng trưởng kinh tế - 3" src="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/thu-tuong-1-1687848857070.jpg" srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/thu-tuong-1-1687848857070.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/06/27/thu-tuong-1-1687848857070.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/06/27/thu-tuong-1-1687848857070.jpg 2x" alt="Thủ tướng Phạm Minh Ch&iacute;nh: 6 cơn gi&oacute; ngược cản trở tăng trưởng kinh tế - 3" data-width="2200" data-height="1466" data-original="https://icdn.dantri.com.vn/2023/06/27/thu-tuong-1-1687848857070.jpg" data-photo-id="2523765" data-track-content="" data-content-name="article-content-image" data-content-piece="article-content-image_2523765" data-content-target="/xa-hoi/thu-tuong-pham-minh-chinh-6-con-gio-nguoc-can-tro-tang-truong-kinh-te-20230627072157879.htm" data-src="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/thu-tuong-1-1687848857070.jpg" data-srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/06/27/thu-tuong-1-1687848857070.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/06/27/thu-tuong-1-1687848857070.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/06/27/thu-tuong-1-1687848857070.jpg 2x" data-ll-status="loaded" />
<figcaption style="box-sizing: border-box; margin: 8px 0px 0px; padding: 0px 30px; font-size: 14px; line-height: 22px; font-style: italic; color: #666666;">
<p style="box-sizing: border-box; margin: 0px;">Thủ tướng Phạm Minh Ch&iacute;nh khẳng định Việt Nam kh&ocirc;ng hy sinh m&ocirc;i trường để đổi lấy tăng trưởng đơn thuần (Ảnh: Đo&agrave;n Bắc).</p>
</figcaption>
</figure>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Chia sẻ với c&aacute;c nhận định v&agrave; định hướng m&agrave; Thủ tướng Ch&iacute;nh phủ đưa ra, Chủ tịch WEF Borge Brende cho hay cộng đồng quốc tế biết đến Việt Nam l&agrave; một trong những quốc gia c&oacute; tăng trưởng kinh tế cao trong khu vực, đang ph&aacute;t triển hết sức năng động v&agrave; hội tụ nhiều tiềm năng để đ&oacute;ng g&oacute;p ng&agrave;y c&agrave;ng tốt cho tăng trưởng kinh tế khu vực v&agrave; to&agrave;n cầu.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Tại phi&ecirc;n thảo luận, l&atilde;nh đạo Ch&iacute;nh phủ c&aacute;c nước, tổ chức quốc tế v&agrave; đại diện tập đo&agrave;n, doanh nghiệp tr&ecirc;n thế giới đ&atilde; đ&aacute;nh gi&aacute; về t&igrave;nh h&igrave;nh kinh tế thế giới v&agrave; giải ph&aacute;p tận dụng hiệu quả c&aacute;c cơ hội để khởi động lại tăng trưởng.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">C&aacute;c diễn giả nhấn mạnh tăng cường li&ecirc;n kết, tr&aacute;nh ph&acirc;n mảnh, ph&acirc;n t&aacute;ch, ph&acirc;n r&atilde; giữa c&aacute;c nước, hạn chế bảo hộ, hướng nội. C&aacute;c &yacute; kiến nhất tr&iacute; cần tăng cường huy động nguồn vốn đa dạng cho ph&aacute;t triển xanh, ứng ph&oacute; với biến đổi kh&iacute; hậu.</p>
</div>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 1, 0, 2)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (18, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'About Us', N'##', N'urlAbout', NULL, 1, 5)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (19, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'News', N'showclientnews', NULL, NULL, 1, 5)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (20, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'Privacy Policy', N'##', NULL, NULL, 1, 5)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (21, CAST(N'2023-06-25T10:43:49.000' AS DateTime), N'Term & Condition', N'##', NULL, NULL, 1, 5)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (22, CAST(N'2023-07-08T06:29:54.000' AS DateTime), N'news 2022', N'', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>
<p>&nbsp;</p>', 1, 0, 2)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (23, CAST(N'2023-07-13T01:41:33.000' AS DateTime), N'Test', N'aaaaaaa', NULL, NULL, 0, 4)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (37, CAST(N'2023-07-20T10:06:49.000' AS DateTime), N'The Best Online Learning Platform', N'<p>WITH YOU DISPLAY THE COURT OF KNOWLEDGE TO MILLIONS OF PEOPLE123</p>', N'<p><img src="uploads/carousel-1.jpg" alt="" width="500" height="281" /></p>', 1, 1, 6)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (38, CAST(N'2023-07-26T12:42:20.000' AS DateTime), N'Get Educated Online From Your Home', N'<p style="font-size: 18px;">The Best Online Learning Platform</p>
<p>&nbsp;</p>', N'<p><img src="uploads/331440188_1149055382426145_3755730341937397029_n.jpg" alt="" width="300" height="188" /></p>', 6, 1, 6)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (1024, CAST(N'2023-07-22T02:31:42.000' AS DateTime), N'dâdadad', N'<h2 class="singular-sapo" style="box-sizing: border-box; margin: 32px 0px 0px; font-size: 18px; line-height: 30px; color: #333333; font-style: italic; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-weight: 400;">(D&acirc;n tr&iacute;) - "Đảng, Nh&agrave; nước lu&ocirc;n đặc biệt quan t&acirc;m c&ocirc;ng t&aacute;c đền ơn, đ&aacute;p nghĩa, coi đ&acirc;y l&agrave; nhiệm vụ ch&iacute;nh trị quan trọng", Thủ tướng Phạm Minh Ch&iacute;nh nhấn mạnh tại Hội nghị Biểu dương người c&oacute; c&ocirc;ng với c&aacute;ch mạng.</h2>
<div class="singular-content" style="box-sizing: border-box; margin: 32px 0px 0px; font-size: 18px; line-height: 30px; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; color: #333333;">
<p style="box-sizing: border-box; margin: 0px 0px 20px;">S&aacute;ng 22/7, tại Thừa Thi&ecirc;n Huế, Thủ tướng Phạm Minh Ch&iacute;nh dự Hội nghị Biểu dương người c&oacute; c&ocirc;ng với c&aacute;ch mạng ti&ecirc;u biểu to&agrave;n quốc năm 2023.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">C&ugrave;ng dự c&oacute; nguy&ecirc;n Chủ tịch Quốc hội Nguyễn Thị Kim Ng&acirc;n, Bộ trưởng Bộ Lao động - Thương Binh v&agrave; X&atilde; hội Đ&agrave;o Ngọc Dung, l&atilde;nh đạo c&aacute;c bộ, ban, ng&agrave;nh, cơ quan Trung ương v&agrave; 300 đại biểu người c&oacute; c&ocirc;ng với c&aacute;ch mạng đến từ khắp mọi miền đất nước.</p>
<figure class="image align-center" style="margin-top: 28px; margin-bottom: 28px; box-sizing: border-box; padding: 0px; float: none;"><img class="entered loaded" style="box-sizing: border-box; max-width: 100%; height: auto; width: 680px; cursor: zoom-in;" title="Thủ tướng: Đền ơn, đ&aacute;p nghĩa l&agrave; nhiệm vụ quan trọng suốt 76 năm qua - 1" src="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg" srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg 2x" alt="Thủ tướng: Đền ơn, đ&aacute;p nghĩa l&agrave; nhiệm vụ quan trọng suốt 76 năm qua - 1" data-width="2200" data-height="1467" data-original="https://icdn.dantri.com.vn/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg" data-photo-id="2558442" data-track-content="" data-content-name="article-content-image" data-content-piece="article-content-image_2558442" data-content-target="/an-sinh/thu-tuong-den-on-dap-nghia-la-nhiem-vu-quan-trong-suot-76-nam-qua-20230722123028214.htm" data-src="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg" data-srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/07/22/z45378827668154beb7e8f4571f0cef8aec940932c52de-1690008552691.jpg 2x" data-ll-status="loaded" />
<figcaption style="color: #666666; margin: 8px 0px 0px; box-sizing: border-box; padding: 0px 30px; font-size: 14px; line-height: 22px; font-style: italic;">
<p style="box-sizing: border-box; margin: 0px;">Thủ tướng Phạm Minh Ch&iacute;nh ph&aacute;t biểu tại hội nghị (Ảnh: Nhật Bắc).</p>
</figcaption>
</figure>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Những đại biểu người c&oacute; c&ocirc;ng với c&aacute;ch mạng trong hội nghị l&agrave; c&aacute;n bộ l&atilde;o th&agrave;nh c&aacute;ch mạng, mẹ Việt Nam anh h&ugrave;ng, anh h&ugrave;ng lực lượng vũ trang, người vợ, người con trung hậu đảm đang, cựu thanh ni&ecirc;n xung phong&hellip;</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Trong số c&aacute;c đại biểu tham dự hội nghị, mẹ Việt Nam anh h&ugrave;ng Nguyễn Thị Điểm (H&agrave; Nội) l&agrave; đại biểu cao tuổi nhất khi tr&ograve;n 98 tuổi v&agrave; 13 đại biểu đ&atilde; tr&ecirc;n 90 tuổi.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Ngo&agrave;i ra, c&ograve;n c&oacute; 25 đại biểu l&agrave; người d&acirc;n tộc thiểu số H&agrave; Nh&igrave;, Hr&ecirc;, Khmer, Mường, N&ugrave;ng, Paco, T&agrave; Ri&ecirc;ng, T&agrave;y, Th&aacute;i, X&ecirc; Đăng.</p>
<figure class="image align-center" style="margin-top: 28px; margin-bottom: 28px; box-sizing: border-box; padding: 0px; float: none;"><img class="entered loaded" style="box-sizing: border-box; max-width: 100%; height: auto; width: 680px; cursor: zoom-in;" title="Thủ tướng: Đền ơn, đ&aacute;p nghĩa l&agrave; nhiệm vụ quan trọng suốt 76 năm qua - 2" src="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg" srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg 2x" alt="Thủ tướng: Đền ơn, đ&aacute;p nghĩa l&agrave; nhiệm vụ quan trọng suốt 76 năm qua - 2" data-width="2200" data-height="1467" data-original="https://icdn.dantri.com.vn/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg" data-photo-id="2558439" data-track-content="" data-content-name="article-content-image" data-content-piece="article-content-image_2558439" data-content-target="/an-sinh/thu-tuong-den-on-dap-nghia-la-nhiem-vu-quan-trong-suot-76-nam-qua-20230722123028214.htm" data-src="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg" data-srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/07/22/z45378827637021db7e8d2ec29a01ef2e2bce8018bfcea-1690008552637.jpg 2x" data-ll-status="loaded" />
<figcaption style="color: #666666; margin: 8px 0px 0px; box-sizing: border-box; padding: 0px 30px; font-size: 14px; line-height: 22px; font-style: italic;">
<p style="box-sizing: border-box; margin: 0px;">Thủ tướng Phạm Minh Ch&iacute;nh thăm hỏi c&aacute;c Mẹ Việt Nam anh h&ugrave;ng (Ảnh: Nhật Bắc).</p>
</figcaption>
</figure>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Tại sự kiện, Bộ trưởng Bộ Lao động - Thương binh v&agrave; X&atilde; hội Đ&agrave;o Ngọc Dung cho biết, 76 năm qua, thực hiện lời dạy của B&aacute;c Hồ, Đảng, Nh&agrave; nước, nh&acirc;n d&acirc;n ta lu&ocirc;n quan t&acirc;m, chăm lo, thực hiện tốt c&ocirc;ng t&aacute;c đền ơn đ&aacute;p nghĩa đối với người c&oacute; c&ocirc;ng với c&aacute;ch mạng v&agrave; th&acirc;n nh&acirc;n.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Hệ thống ch&iacute;nh s&aacute;ch, ph&aacute;p luật ưu đ&atilde;i người c&oacute; c&ocirc;ng đang từng bước ho&agrave;n thiện, ph&ugrave; hợp với điều kiện kinh tế - x&atilde; hội. Đối tượng người c&oacute; c&ocirc;ng ng&agrave;y mở rộng, chế độ ưu đ&atilde;i ng&agrave;y một n&acirc;ng cao, gắn liền với sự đảm bảo c&ocirc;ng bằng, đồng thuận của x&atilde; hội.</p>
<figure class="image align-center" style="margin-top: 28px; margin-bottom: 28px; box-sizing: border-box; padding: 0px; float: none;"><img class="entered loaded" style="box-sizing: border-box; max-width: 100%; height: auto; width: 680px; cursor: zoom-in;" title="Thủ tướng: Đền ơn, đ&aacute;p nghĩa l&agrave; nhiệm vụ quan trọng suốt 76 năm qua - 3" src="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg" srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg 2x" alt="Thủ tướng: Đền ơn, đ&aacute;p nghĩa l&agrave; nhiệm vụ quan trọng suốt 76 năm qua - 3" data-width="2560" data-height="1707" data-original="https://icdn.dantri.com.vn/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg" data-photo-id="2558331" data-track-content="" data-content-name="article-content-image" data-content-piece="article-content-image_2558331" data-content-target="/an-sinh/thu-tuong-den-on-dap-nghia-la-nhiem-vu-quan-trong-suot-76-nam-qua-20230722123028214.htm" data-src="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg" data-srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/07/22/z45377254349464194d81aedf6cce937b8ee879f10b2c6-1690003035798.jpg 2x" data-ll-status="loaded" />
<figcaption style="color: #666666; margin: 8px 0px 0px; box-sizing: border-box; padding: 0px 30px; font-size: 14px; line-height: 22px; font-style: italic;">
<p style="box-sizing: border-box; margin: 0px;">Bộ trưởng Bộ Lao động - Thương Binh v&agrave; X&atilde; hội Đ&agrave;o Ngọc Dung thăm hỏi c&aacute;c Mẹ Việt Nam anh h&ugrave;ng (Ảnh: Tống Gi&aacute;p).</p>
</figcaption>
</figure>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Thủ tướng Phạm Minh Ch&iacute;nh b&agrave;y tỏ, chiến tranh đ&atilde; l&ugrave;i xa, đất nước đ&atilde; độc lập, thống nhất nhưng vẫn c&ograve;n đ&oacute; biết bao nỗi đau thương. Những giọt nước mắt vẫn c&ograve;n lăn tr&ecirc;n m&aacute; của người mẹ v&igrave; "ba lần tiễn con đi, hai lần kh&oacute;c thầm lặng lẽ".</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Những vết thương chiến tranh vẫn hằng ng&agrave;y đau nhức, nhất l&agrave; l&uacute;c tr&aacute;i nắng, trở trời, di chứng do chất độc da cam d&agrave;y v&ograve; biết bao số phận. Những &aacute;nh mắt m&ograve;n mỏi ng&oacute;ng tr&ocirc;ng, khắc khoải đợi chờ của những gia đ&igrave;nh chưa c&oacute; th&ocirc;ng tin, chưa được biết phần mộ của con, của em, của vợ, chồng&hellip; ở đ&acirc;u.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Thấu hiểu, sẻ chia với những nỗi đau đ&oacute;, trong suốt 76 năm qua, Đảng, Nh&agrave; nước lu&ocirc;n đặc biệt quan t&acirc;m c&ocirc;ng t&aacute;c đền ơn, đ&aacute;p nghĩa v&agrave; ban h&agrave;nh nhiều chủ trương, ch&iacute;nh s&aacute;ch hỗ trợ đối với thương binh, bệnh binh, th&acirc;n nh&acirc;n liệt sỹ, lu&ocirc;n coi đ&oacute; l&agrave; nhiệm vụ ch&iacute;nh trị quan trọng, thường xuy&ecirc;n.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Mặc d&ugrave; vậy, vẫn c&ograve;n nhiều trăn trở khi đời sống của một bộ phận thương bệnh binh, gia đ&igrave;nh người c&oacute; c&ocirc;ng với c&aacute;ch mạng c&ograve;n kh&oacute; khăn, nhiều liệt sỹ chưa t&igrave;m được h&agrave;i cốt, chưa x&aacute;c định được danh t&iacute;nh...</p>
<figure class="image align-center" style="margin-top: 28px; margin-bottom: 28px; box-sizing: border-box; padding: 0px; float: none;"><img class="entered loaded" style="box-sizing: border-box; max-width: 100%; height: auto; width: 680px; cursor: zoom-in;" title="Thủ tướng: Đền ơn, đ&aacute;p nghĩa l&agrave; nhiệm vụ quan trọng suốt 76 năm qua - 4" src="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg" srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg 2x" alt="Thủ tướng: Đền ơn, đ&aacute;p nghĩa l&agrave; nhiệm vụ quan trọng suốt 76 năm qua - 4" data-width="2048" data-height="1364" data-original="https://icdn.dantri.com.vn/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg" data-photo-id="2558443" data-track-content="" data-content-name="article-content-image" data-content-piece="article-content-image_2558443" data-content-target="/an-sinh/thu-tuong-den-on-dap-nghia-la-nhiem-vu-quan-trong-suot-76-nam-qua-20230722123028214.htm" data-src="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg" data-srcset="https://icdn.dantri.com.vn/thumb_w/680/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg 1x, https://icdn.dantri.com.vn/thumb_w/1020/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg 1.5x, https://icdn.dantri.com.vn/thumb_w/1360/2023/07/22/z453788276665993c1319a819eb9ac0f4e4dc1dc34ea84-1690008552778.jpg 2x" data-ll-status="loaded" />
<figcaption style="color: #666666; margin: 8px 0px 0px; box-sizing: border-box; padding: 0px 30px; font-size: 14px; line-height: 22px; font-style: italic;">
<p style="box-sizing: border-box; margin: 0px;">Thủ tướng Phạm Minh Ch&iacute;nh trao kỷ vật v&agrave; qu&agrave; cho c&aacute;c người c&oacute; c&ocirc;ng (Ảnh: Nhật Bắc).</p>
</figcaption>
</figure>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Thủ tướng Phạm Minh Ch&iacute;nh đề nghị, c&aacute;c cấp, c&aacute;c ng&agrave;nh, c&aacute;c địa phương tiếp tục thực hiện thật tốt chủ trương của Đảng, ch&iacute;nh s&aacute;ch, ph&aacute;p luật của Nh&agrave; nước, đẩy mạnh hơn nữa c&ocirc;ng t&aacute;c chăm s&oacute;c thương binh, bệnh binh, gia đ&igrave;nh liệt sĩ, người c&oacute; c&ocirc;ng với c&aacute;ch mạng.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">"Với tr&aacute;ch nhiệm lớn lao v&agrave; nghĩa t&igrave;nh s&acirc;u nặng, Đảng, Nh&agrave; nước, Ch&iacute;nh phủ v&agrave; nh&acirc;n d&acirc;n ta nguyện tiếp tục chăm lo chu đ&aacute;o để xoa dịu nỗi đau, l&agrave;m vơi đi nỗi nhớ, để đời sống vật chất, tinh thần của người c&oacute; c&ocirc;ng ng&agrave;y c&agrave;ng được n&acirc;ng l&ecirc;n, đầy đủ, tốt đẹp hơn", Thủ tướng Phạm Minh Ch&iacute;nh nhấn mạnh.</p>
</div>', N'<p><img src="uploads/346048.jpeg" alt="" width="512" height="512" /></p>', 1, 0, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (1025, CAST(N'2023-07-26T09:58:13.000' AS DateTime), N'Chúng tôi thi đấu trận này tốt hơn đội Thái Lan', N'<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">C&aacute;c vụ tập k&iacute;ch tuần trước của Nga chủ yếu nhằm v&agrave;o cảng ch&iacute;nh Odessa v&agrave; Mykolaiv ở miền Nam Ukraine để đ&aacute;p trả việc Ukraine bị c&aacute;o buộc tấn c&ocirc;ng cầu Crimea bằng hai xuồng kh&ocirc;ng người l&aacute;i.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Tuy nhi&ecirc;n, cuộc tập k&iacute;ch rạng s&aacute;ng 24/7 của Nga lại nhằm v&agrave;o hạ tầng dọc s&ocirc;ng Danube, một tuyến đường xuất khẩu thay thế của Ukraine ở Odessa sau khi Nga th&ocirc;ng b&aacute;o kh&ocirc;ng gia hạn S&aacute;ng kiến Ngũ cốc Biển Đen.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">"Nga li&ecirc;n tục tấn c&ocirc;ng v&ugrave;ng Odessa, lần n&agrave;y, hạ tầng cảng tr&ecirc;n s&ocirc;ng Danube trở th&agrave;nh mục ti&ecirc;u", Oleh Kiper, một quan chức địa phương, cho hay.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Theo cảnh s&aacute;t địa phương, c&aacute;c kho ngũ cốc c&ugrave;ng với nhiều th&ugrave;ng h&agrave;ng h&oacute;a kh&aacute;c bị ph&aacute; hủy. Trang tin&nbsp;<em style="box-sizing: border-box;">Reni-Odesa&nbsp;</em>dẫn lời một quan chức địa phương n&oacute;i rằng, 3 kho chứa ngũ cốc dọc s&ocirc;ng Danube ở th&agrave;nh phố cảng Reni đ&atilde; bị ph&aacute; hủy trong vụ tập k&iacute;ch bằng m&aacute;y bay kh&ocirc;ng người l&aacute;i (UAV) của Nga rạng s&aacute;ng 24/7.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Th&agrave;nh phố Reni được coi l&agrave; trung t&acirc;m vận tải quan trọng b&ecirc;n s&ocirc;ng Danube, đưa ngũ cốc Ukraine sang Romania.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Trong một diễn biến li&ecirc;n quan kh&aacute;c, một số h&atilde;ng truyền th&ocirc;ng của Ukraine đưa tin về c&aacute;c vụ nổ ở khu vực Izmail, một thị trấn&nbsp;cảng&nbsp;nhỏ b&ecirc;n bờ s&ocirc;ng&nbsp;Danube. Tuy nhi&ecirc;n, hiện chưa c&oacute; th&ocirc;ng tin về thiệt hại. Dữ liệu theo d&otilde;i hoạt động vận tải cho thấy, khoảng 30 t&agrave;u &ugrave;n ứ gần Izmail, song kh&ocirc;ng r&otilde; nguy&ecirc;n nh&acirc;n v&igrave; sao.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Sau vụ tấn c&ocirc;ng, Tổng thống Romania Klaus Iohannis cảnh b&aacute;o: "Sự leo thang gần đ&acirc;y đặt ra những rủi ro nghi&ecirc;m trọng đối với an ninh ở Biển Đen. N&oacute; cũng ảnh hưởng đến hoạt động vận chuyển ngũ cốc của Ukraine, do đ&oacute; ảnh hưởng đến an ninh lương thực to&agrave;n cầu".</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Một thương nh&acirc;n ch&acirc;u &Acirc;u b&igrave;nh luận: "Bất cứ sự gi&aacute;n đoạn n&agrave;o của c&aacute;c tuyến đường vận tải ở đ&acirc;y c&oacute; thể nhanh ch&oacute;ng ảnh hưởng đến nguồn cung ngũ cốc to&agrave;n cầu".</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Thương nh&acirc;n n&agrave;y gọi đ&acirc;y l&agrave; "diễn biến lớn v&agrave; một đ&ograve;n gi&aacute;ng mạnh" v&agrave;o ng&agrave;nh xuất khẩu của Ukraine. "Nếu kh&ocirc;ng c&oacute; h&agrave;nh lang xuất khẩu ngũ cốc Biển Đen v&agrave; giờ đ&acirc;y l&agrave; c&aacute;c cuộc tấn c&ocirc;ng v&agrave;o c&aacute;c tuyến đường thay thế, sẽ rất kh&oacute; đưa ngũ cốc khỏi Ukraine".</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;"><img style="display: block; margin-left: auto; margin-right: auto;" src="uploads/download (2).jpg" alt="" width="400" height="238" /></p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;"><img src="uploads/Customer.drawio (5).png" alt="" width="1093" height="661" /></p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">&nbsp;</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">H&ocirc;m 17/7, Nga th&ocirc;ng b&aacute;o kh&ocirc;ng gia hạn S&aacute;ng kiến Ngũ cốc Biển Đen sau khi c&aacute;o buộc Ukraine tấn c&ocirc;ng cầu nối b&aacute;n đảo Crimea với đất liền Nga. Đ&acirc;y vốn l&agrave; thỏa thuận được Nga v&agrave; Ukraine k&yacute; kết hồi m&ugrave;a h&egrave; năm ngo&aacute;i th&ocirc;ng qua Li&ecirc;n hợp quốc v&agrave; Thổ Nhĩ Kỳ. Thỏa thuận nhằm tạo h&agrave;nh lang an to&agrave;n cho hoạt động xuất khẩu ngũ cốc của Ukraine v&agrave; ph&acirc;n b&oacute;n của Nga.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Moscow nhiều lần c&aacute;o buộc Kiev lợi dụng thỏa thuận, d&ugrave;ng t&agrave;u h&agrave;ng ngụy trang để vận chuyển vũ kh&iacute;. Kiev đ&atilde; b&aacute;c bỏ c&aacute;o buộc n&agrave;y.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Động th&aacute;i của Nga khiến gi&aacute; l&uacute;a m&igrave; v&agrave; ng&ocirc; tr&ecirc;n thị trường&nbsp;<a style="box-sizing: border-box; color: #0066cc; text-decoration-line: none;" href="https://dantri.com.vn/the-gioi.htm" data-auto-link-id="61328404fb044100119a1470" data-track-content="" data-content-name="article-content-autolink" data-content-piece="article-content-autolink_61328404fb044100119a1470" data-content-target="/the-gioi/nga-chuyen-huong-tan-cong-o-ukraine-20230725144123334.htm">thế giới</a>&nbsp;tăng mạnh. Tổng thư k&yacute; Li&ecirc;n hợp quốc Antonio Guterres đ&atilde; k&ecirc;u gọi Moscow kh&ocirc;i phục thỏa thuận để tr&aacute;nh ảnh hưởng ti&ecirc;u cực đến nhiều quốc gia phụ thuộc v&agrave;o nguồn cung ngũ cốc từ Biển Đen.</p>
<p>&nbsp;</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>', 6, 1, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (1026, CAST(N'2023-07-25T11:11:24.000' AS DateTime), N'Chúng tôi thi đấu trận này tốt hơn đội Thái Lan', N'<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">C&aacute;c vụ tập k&iacute;ch tuần trước của Nga chủ yếu nhằm v&agrave;o cảng ch&iacute;nh Odessa v&agrave; Mykolaiv ở miền Nam Ukraine để đ&aacute;p trả việc Ukraine bị c&aacute;o buộc tấn c&ocirc;ng cầu Crimea bằng hai xuồng kh&ocirc;ng người l&aacute;i.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Tuy nhi&ecirc;n, cuộc tập k&iacute;ch rạng s&aacute;ng 24/7 của Nga lại nhằm v&agrave;o hạ tầng dọc s&ocirc;ng Danube, một tuyến đường xuất khẩu thay thế của Ukraine ở Odessa sau khi Nga th&ocirc;ng b&aacute;o kh&ocirc;ng gia hạn S&aacute;ng kiến Ngũ cốc Biển Đen.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">"Nga li&ecirc;n tục tấn c&ocirc;ng v&ugrave;ng Odessa, lần n&agrave;y, hạ tầng cảng tr&ecirc;n s&ocirc;ng Danube trở th&agrave;nh mục ti&ecirc;u", Oleh Kiper, một quan chức địa phương, cho hay.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Theo cảnh s&aacute;t địa phương, c&aacute;c kho ngũ cốc c&ugrave;ng với nhiều th&ugrave;ng h&agrave;ng h&oacute;a kh&aacute;c bị ph&aacute; hủy. Trang tin&nbsp;<em style="box-sizing: border-box;">Reni-Odesa&nbsp;</em>dẫn lời một quan chức địa phương n&oacute;i rằng, 3 kho chứa ngũ cốc dọc s&ocirc;ng Danube ở th&agrave;nh phố cảng Reni đ&atilde; bị ph&aacute; hủy trong vụ tập k&iacute;ch bằng m&aacute;y bay kh&ocirc;ng người l&aacute;i (UAV) của Nga rạng s&aacute;ng 24/7.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Th&agrave;nh phố Reni được coi l&agrave; trung t&acirc;m vận tải quan trọng b&ecirc;n s&ocirc;ng Danube, đưa ngũ cốc Ukraine sang Romania.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Trong một diễn biến li&ecirc;n quan kh&aacute;c, một số h&atilde;ng truyền th&ocirc;ng của Ukraine đưa tin về c&aacute;c vụ nổ ở khu vực Izmail, một thị trấn&nbsp;cảng&nbsp;nhỏ b&ecirc;n bờ s&ocirc;ng&nbsp;Danube. Tuy nhi&ecirc;n, hiện chưa c&oacute; th&ocirc;ng tin về thiệt hại. Dữ liệu theo d&otilde;i hoạt động vận tải cho thấy, khoảng 30 t&agrave;u &ugrave;n ứ gần Izmail, song kh&ocirc;ng r&otilde; nguy&ecirc;n nh&acirc;n v&igrave; sao.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Sau vụ tấn c&ocirc;ng, Tổng thống Romania Klaus Iohannis cảnh b&aacute;o: "Sự leo thang gần đ&acirc;y đặt ra những rủi ro nghi&ecirc;m trọng đối với an ninh ở Biển Đen. N&oacute; cũng ảnh hưởng đến hoạt động vận chuyển ngũ cốc của Ukraine, do đ&oacute; ảnh hưởng đến an ninh lương thực to&agrave;n cầu".</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Một thương nh&acirc;n ch&acirc;u &Acirc;u b&igrave;nh luận: "Bất cứ sự gi&aacute;n đoạn n&agrave;o của c&aacute;c tuyến đường vận tải ở đ&acirc;y c&oacute; thể nhanh ch&oacute;ng ảnh hưởng đến nguồn cung ngũ cốc to&agrave;n cầu".</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Thương nh&acirc;n n&agrave;y gọi đ&acirc;y l&agrave; "diễn biến lớn v&agrave; một đ&ograve;n gi&aacute;ng mạnh" v&agrave;o ng&agrave;nh xuất khẩu của Ukraine. "Nếu kh&ocirc;ng c&oacute; h&agrave;nh lang xuất khẩu ngũ cốc Biển Đen v&agrave; giờ đ&acirc;y l&agrave; c&aacute;c cuộc tấn c&ocirc;ng v&agrave;o c&aacute;c tuyến đường thay thế, sẽ rất kh&oacute; đưa ngũ cốc khỏi Ukraine".</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">H&ocirc;m 17/7, Nga th&ocirc;ng b&aacute;o kh&ocirc;ng gia hạn S&aacute;ng kiến Ngũ cốc Biển Đen sau khi c&aacute;o buộc Ukraine tấn c&ocirc;ng cầu nối b&aacute;n đảo Crimea với đất liền Nga. Đ&acirc;y vốn l&agrave; thỏa thuận được Nga v&agrave; Ukraine k&yacute; kết hồi m&ugrave;a h&egrave; năm ngo&aacute;i th&ocirc;ng qua Li&ecirc;n hợp quốc v&agrave; Thổ Nhĩ Kỳ. Thỏa thuận nhằm tạo h&agrave;nh lang an to&agrave;n cho hoạt động xuất khẩu ngũ cốc của Ukraine v&agrave; ph&acirc;n b&oacute;n của Nga.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Moscow nhiều lần c&aacute;o buộc Kiev lợi dụng thỏa thuận, d&ugrave;ng t&agrave;u h&agrave;ng ngụy trang để vận chuyển vũ kh&iacute;. Kiev đ&atilde; b&aacute;c bỏ c&aacute;o buộc n&agrave;y.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px; color: #333333; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; font-size: 18px;">Động th&aacute;i của Nga khiến gi&aacute; l&uacute;a m&igrave; v&agrave; ng&ocirc; tr&ecirc;n thị trường&nbsp;<a style="box-sizing: border-box; color: #0066cc; text-decoration-line: none;" href="https://dantri.com.vn/the-gioi.htm" data-auto-link-id="61328404fb044100119a1470" data-track-content="" data-content-name="article-content-autolink" data-content-piece="article-content-autolink_61328404fb044100119a1470" data-content-target="/the-gioi/nga-chuyen-huong-tan-cong-o-ukraine-20230725144123334.htm">thế giới</a>&nbsp;tăng mạnh. Tổng thư k&yacute; Li&ecirc;n hợp quốc Antonio Guterres đ&atilde; k&ecirc;u gọi Moscow kh&ocirc;i phục thỏa thuận để tr&aacute;nh ảnh hưởng ti&ecirc;u cực đến nhiều quốc gia phụ thuộc v&agrave;o nguồn cung ngũ cốc từ Biển Đen.</p>
<p>&nbsp;</p>', N'<p><img src="uploads/346967.jpeg" alt="" width="512" height="512" /></p>', 6, 0, 1)
INSERT [dbo].[News] ([NewsID], [CreateNewDate], [NewsTitle], [News], [NewsImg], [AdminID], [NewsStatus], [newsTypeID]) VALUES (1027, CAST(N'2023-07-26T12:31:40.000' AS DateTime), N'Cục CSGT lý giải việc nhiều biển ', N'<div class="singular-content" style="box-sizing: border-box; margin: 32px 0px 0px; font-size: 18px; line-height: 30px; font-family: ''Noto Serif'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Helvetica Neue'', Arial, ''Apple Color Emoji'', ''Segoe UI Emoji'', ''Segoe UI Symbol'', serif; color: #333333;">
<p style="box-sizing: border-box; margin: 0px 0px 20px;">H&agrave; Nội. Nội dung cuộc l&agrave;m việc về thực hiện một số Nghị quyết của Quốc hội v&agrave; x&acirc;y dựng Dự &aacute;n Luật Thủ đ&ocirc; (sửa đổi).&nbsp;</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Cụ thể, &ocirc;ng Dũng cho rằng đối với nhu cầu x&acirc;y dựng 10 tuyến đường sắt tr&ecirc;n địa b&agrave;n H&agrave; Nội, nếu thực hiện theo quy tr&igrave;nh, c&aacute;ch thức hiện nay sẽ manh m&uacute;n v&agrave; k&eacute;o d&agrave;i. Do đ&oacute;, &ocirc;ng đề xuất cơ chế d&agrave;nh ri&ecirc;ng một g&oacute;i vay ODA d&agrave;nh cho cả 10 tuyến để thực hiện đồng bộ, bảo đảm kỹ thuật v&agrave; thời gian vận h&agrave;nh...</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Theo B&iacute; thư H&agrave; Nội, nội dung cuộc l&agrave;m việc đều l&agrave; những h&agrave;nh lang ph&aacute;p l&yacute; quan trọng để H&agrave; Nội c&oacute; điều kiện ph&aacute;t triển bứt ph&aacute;, g&oacute;p phần hiện thực h&oacute;a mục ti&ecirc;u Nghị quyết số 15 của Bộ Ch&iacute;nh trị.&nbsp;</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">&Ocirc;ng Dũng khẳng định th&agrave;nh phố tiếp thu đầy đủ, nghi&ecirc;m t&uacute;c c&aacute;c &yacute; kiến trao đổi, g&oacute;p &yacute; của Quốc hội, Ủy ban của Quốc hội v&agrave; c&aacute;c bộ, ng&agrave;nh Trung ương; đặc biệt l&agrave; tiếp thu chỉ đạo của Chủ tịch Quốc hội để tổ chức triển khai thực hiện, ho&agrave;n th&agrave;nh c&aacute;c b&aacute;o c&aacute;o.</p>
<p style="box-sizing: border-box; margin: 0px 0px 20px;">Trong đ&oacute;, th&agrave;nh phố sẽ ho&agrave;n thiện hồ sơ, tr&igrave;nh Quốc hội 3 nội dung c&oacute; t&iacute;nh chiến lược v&agrave;o kỳ họp th&aacute;ng 10 tới gồm: Luật Thủ đ&ocirc; (sửa đổi); Đồ &aacute;n điều chỉnh tổng thể Quy hoạch chung x&acirc;y dựng thủ đ&ocirc; H&agrave; Nội đến năm 2030, tầm nh&igrave;n đến năm 2050; Quy hoạch thủ đ&ocirc; H&agrave; Nội thời kỳ 2021-2030, tầm nh&igrave;n đến năm 2050.&nbsp;</p>
</div>', N'<p><img src="uploads/576aaea60ec505d3b9017d1d36c998de.jpg" alt="" width="500" height="500" /></p>', 6, 0, 9)
SET IDENTITY_INSERT [dbo].[News] OFF
GO
SET IDENTITY_INSERT [dbo].[newsType] ON 

INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (1, N'Sale')
INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (2, N'CourseNews')
INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (3, N'Footer')
INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (4, N'Navbar')
INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (5, N'Quick Link')
INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (6, N'Banner')
INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (7, N'Show all News')
INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (8, N'3 news gan nha112t')
INSERT [dbo].[newsType] ([newsTypeID], [newTypeName]) VALUES (9, N'Hot Sale')
SET IDENTITY_INSERT [dbo].[newsType] OFF
GO
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (1, 1, 500000, 5)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (1, 2, 400000, 1)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (1, 3, 200000, 1)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (48, 1, 250, 1)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (49, 1, 250, 1)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (50, 2, 350, 1)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (51, 1, 250, 1)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (52, 1, 250, 1)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (53, 5, 140000, 2)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (53, 6, 1500000, 3)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (54, 3, 350000, 2)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (55, 3, 35000, 1)
INSERT [dbo].[OrderBook] ([OrderID], [Course_BookID], [price], [quantity]) VALUES (57, 3, 35000, 1)
GO
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (1, 1, 10000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (1, 4, 11000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (48, 1, 150000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (50, 1, 150000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (51, 2, 200000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (52, 2, 200000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (52, 6, 250000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (53, 2, 200000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (53, 3, 200000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (54, 1, 150000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (55, 3, 200000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (56, 1, 150000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (57, 4, 100000)
INSERT [dbo].[OrderDetail] ([OrderID], [CourseID], [price]) VALUES (58, 4, 100000)
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (1, 1, CAST(N'2023-07-26T00:00:00.000' AS DateTime), 1, 250000, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (2, 1, CAST(N'2023-04-03T00:00:00.000' AS DateTime), 0, 450000, N'received')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (5, 1, CAST(N'2023-04-03T00:00:00.000' AS DateTime), 0, 250000, N'received')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (6, 1, CAST(N'2023-04-03T00:00:00.000' AS DateTime), 0, 250000, N'received')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (7, 1, CAST(N'2023-04-03T00:00:00.000' AS DateTime), 0, 250000, N'received')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (48, 2, CAST(N'2023-07-13T00:00:00.000' AS DateTime), 0, 150250, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (49, 2, CAST(N'2023-07-13T00:00:00.000' AS DateTime), 0, 250, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (50, 2, CAST(N'2023-07-13T00:00:00.000' AS DateTime), 0, 150350, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (51, 1, CAST(N'2023-07-13T00:00:00.000' AS DateTime), 0, 200250, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (52, 1, CAST(N'2023-07-22T00:00:00.000' AS DateTime), 1, 450250, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (53, 2, CAST(N'2023-07-22T00:00:00.000' AS DateTime), 0, 5180000, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (54, 2, CAST(N'2023-07-25T00:00:00.000' AS DateTime), 0, 850000, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (55, 1, CAST(N'2023-07-26T00:00:00.000' AS DateTime), 0, 235000, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (56, 2, CAST(N'2023-07-26T00:00:00.000' AS DateTime), 1, 150000, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (57, 2, CAST(N'2023-07-26T00:00:00.000' AS DateTime), 0, 135000, N'approved')
INSERT [dbo].[Orders] ([OrderID], [UserID], [OrderDate], [CheckPaymentStatus], [TotalPrice], [orderStatus]) VALUES (58, 2, CAST(N'2023-07-26T00:00:00.000' AS DateTime), 1, 100000, N'approved')
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (1, N'duong', N'176e70e29dd8668581237247c18521bf1ef5cfbe9f0f0fde6f8d8bf3af2a3fa6', N'Nguyen Canh Duong', CAST(N'2003-01-01' AS Date), N'0987656321', N'So 3 Tran Duy Hung', N'duong@gmail.com', 1, N'thumb-340327.png', NULL, N'6cec14318a216bc4e016912b2f1b83425c457d0054c3565b6bcd15521ffe57b0')
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (2, N'duy', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'Hoang Duc Duy', CAST(N'2003-02-02' AS Date), N'0987566321', N'So 3 Le Trong Tan', N'duy@gmail.com', 1, N'ai.jpg', NULL, N'a58814766376f236b87c42b237e6c9232ba8af01044b1e54834dc3481071bde1')
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (3, N'thai', N'thai123', N'Hoang Duc Thai', CAST(N'2003-01-02' AS Date), N'0667566321', N'So 3 Pho hue', N'thai@gmail.com', 1, N'ai.jpg', NULL, NULL)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (4, N'user1', N'user123', N'User', CAST(N'2003-01-02' AS Date), N'0667566321', N'FPT', N'user@gmail.com', 1, N'ai.jpg', NULL, NULL)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (5, N'nam', N'176e70e29dd8668581237247c18521bf1ef5cfbe9f0f0fde6f8d8bf3af2a3fa6', N'User', CAST(N'2003-01-02' AS Date), N'0366476002', N'FPT', N'user11@gmail.com', 1, N'348267.png', NULL, NULL)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (6, N'nam222', N'176e70e29dd8668581237247c18521bf1ef5cfbe9f0f0fde6f8d8bf3af2a3fa6', N'KAiiiiiiii', CAST(N'2023-06-12' AS Date), N'0366476003', N'dadadad', N'lazvell3@gmail.com', 1, N'346756.png', NULL, NULL)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (7, N'namddhe163800@fpt.edu.vn', NULL, N'Dinh Dai Nam (K16_HL)', NULL, NULL, NULL, N'namddhe163800@fpt.edu.vn', 1, N'https://lh3.googleusercontent.com/a/AAcHTtdx-1T6Gcs3GWGbOiwpckvDueXMks3AuIAT0Iy0=s96-c', N'117991976353151829026', NULL)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (8, N'hdtam2003', N'4599f3fe61795f9d7e95033b0ddccec7858e533d9d21d63e7587ba721695018d', N'Hoang Duc Tam', CAST(N'2023-10-30' AS Date), N'0936197146', N'Ha Noi', N'hdtam2003@gmail.com', 1, NULL, NULL, N'b80de2f23ded265f6adf94d38240d8b4cf65d2b24e0c59a36bacd2d3e94648c9')
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Fullname], [Dob], [Phonenumber], [Address], [Email], [accStatus], [uImage], [googleID], [RememberMe]) VALUES (12, N'hd@@', N'4599f3fe61795f9d7e95033b0ddccec7858e533d9d21d63e7587ba721695018d', N'HTML,CSS,JS', CAST(N'2023-05-23' AS Date), N'0912345678', N'adasddsad', N'hdtam2003222@gmail.com', 1, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[BookOfCourse]  WITH CHECK ADD FOREIGN KEY([Course_BookID])
REFERENCES [dbo].[Course_Book] ([Course_BookID])
GO
ALTER TABLE [dbo].[BookOfCourse]  WITH CHECK ADD FOREIGN KEY([CourseID])
REFERENCES [dbo].[Course] ([CourseID])
GO
ALTER TABLE [dbo].[Course]  WITH CHECK ADD FOREIGN KEY([adminID])
REFERENCES [dbo].[Admins] ([AdminID])
GO
ALTER TABLE [dbo].[Course_Document]  WITH CHECK ADD FOREIGN KEY([CourseVideoID])
REFERENCES [dbo].[CourseVideo] ([CourseVideoID])
GO
ALTER TABLE [dbo].[CourseVideo]  WITH CHECK ADD FOREIGN KEY([CourseID])
REFERENCES [dbo].[Course] ([CourseID])
GO
ALTER TABLE [dbo].[Discount]  WITH CHECK ADD FOREIGN KEY([AdminID])
REFERENCES [dbo].[Admins] ([AdminID])
GO
ALTER TABLE [dbo].[Discount]  WITH CHECK ADD FOREIGN KEY([CourseID])
REFERENCES [dbo].[Course] ([CourseID])
GO
ALTER TABLE [dbo].[hasCategory]  WITH CHECK ADD FOREIGN KEY([CourseID])
REFERENCES [dbo].[Course] ([CourseID])
GO
ALTER TABLE [dbo].[hasCategory]  WITH CHECK ADD FOREIGN KEY([Course_CategoryID])
REFERENCES [dbo].[Course_Category] ([Course_CategoryID])
GO
ALTER TABLE [dbo].[include]  WITH CHECK ADD FOREIGN KEY([Course_ProcessID])
REFERENCES [dbo].[Course_Process] ([Course_ProcessID])
GO
ALTER TABLE [dbo].[include]  WITH CHECK ADD FOREIGN KEY([CourseID])
REFERENCES [dbo].[Course] ([CourseID])
GO
ALTER TABLE [dbo].[News]  WITH CHECK ADD FOREIGN KEY([AdminID])
REFERENCES [dbo].[Admins] ([AdminID])
GO
ALTER TABLE [dbo].[News]  WITH CHECK ADD FOREIGN KEY([newsTypeID])
REFERENCES [dbo].[newsType] ([newsTypeID])
GO
ALTER TABLE [dbo].[OrderBook]  WITH CHECK ADD FOREIGN KEY([Course_BookID])
REFERENCES [dbo].[Course_Book] ([Course_BookID])
GO
ALTER TABLE [dbo].[OrderBook]  WITH CHECK ADD FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([CourseID])
REFERENCES [dbo].[Course] ([CourseID])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
USE [master]
GO
ALTER DATABASE [SWP391] SET  READ_WRITE 
GO
