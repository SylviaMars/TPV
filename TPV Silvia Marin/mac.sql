{\rtf1\ansi\ansicpg1252\cocoartf1504\cocoasubrtf830
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww12600\viewh7280\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 //create database mac;\
//use mac;\
\
create table productos (\
    C\'f3digo varchar(50),\
    Nombre varchar(50),\
    Precio int,\
    Tipo varchar(50),\
    Color boolean,\
    Cantidad int\
);\
\
insert into productos values \
('SF001','STUDIO FIX FLUID CONCEALER',21,'CORRECTOR',false,20),\
('SF002','STUDIO FIX FLUID FOUND.',35,'BASE',false,15),\
('IE003','IN EXTREME MASCARA',24,'MASCARA',false,50),\
('MI004','MINERALIZE POWDER',35,'POWDER',false,10),\
('SF005','STUDIO FIX POWDER',35,'POWDER',false,16),\
('MI006','MINERALIZE EYE PALETTE',40,'EYESHADOW',true,5),\
('MI007','MINERALIZE EYE PALETTE',40,'EYESHADOW',true,8),\
('MI008','MINERALIZE EYE PALETTE',40,'EYESHADOW',true,8),\
('PL009','EMPTY PALETTE',8,'ACCESORIES',false,10),\
('BC010','BRUSH CLEANSER',12,'ACCESORIES',false,20);\
   }