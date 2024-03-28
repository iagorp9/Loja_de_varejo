drop database if exists bd_loja;

create database if not exists bd_loja 
	default character set utf8
    default collate utf8_general_ci;
    
use bd_loja;
create table tb_cliente(
	pkidcliente int primary key not null auto_increment,
    nome varchar(100) not null,
    cpf bigint not null unique
)engine InnoDB;
  
create table tb_cargo(
	pkidcargo int primary key not null auto_increment,
    nome varchar(45) not null unique,
    salario float not null
)engine InnoDB;

create table tb_fornecedor(
	pkidfornecedor int primary key not null auto_increment,
    nome varchar(200) not null,
    cnpj bigint not null unique
)engine InnoDB;

create table tb_funcionario(
	pkidfuncionario int primary key not null auto_increment,
    nome varchar(100) not null,
    cpf bigint not null unique,
    fkidcargo int not null,
    foreign key (fkidcargo) references tb_cargo (pkidcargo)
)engine InnoDB;

create table tb_endereco(
	pkidendereco int primary key not null auto_increment,
    rua varchar(200) not null,
    numero int not null,
    bairro varchar (150) not null,
    fkidcliente int null,
    fkidfuncionario int null,
    fkidfornecedor int null,
    foreign key (fkidcliente) references tb_cliente(pkidcliente)on delete cascade,
    foreign key (fkidfuncionario) references tb_funcionario(pkidfuncionario),
    foreign key (fkidfornecedor) references tb_fornecedor(pkidfornecedor)  
)engine InnoDB;

create table tb_contato(
	pkidcontato int primary key not null auto_increment,
    telefone varchar(45) not null,
    email varchar(100) null,
    fkidcliente int null,
    fkidfuncionario int null,
    fkidfornecedor int null,
    foreign key (fkidcliente) references tb_cliente(pkidcliente) on delete cascade,
    foreign key (fkidfuncionario) references tb_funcionario(pkidfuncionario),
    foreign key (fkidfornecedor) references tb_fornecedor(pkidfornecedor) 
)engine InnoDB;

create table tb_produto(
	pkidproduto int primary key not null auto_increment,
    nome varchar(255) not null,
    valor float not null,
    fkidfornecedor int not null,
    foreign key (fkidfornecedor) references tb_fornecedor(pkidfornecedor)
)engine InnoDB;

create table tb_venda(
	pkidvenda int primary key not null auto_increment,
    datavenda timestamp not null default current_timestamp(),
    total float not null,
	fkidcliente int not null,
    fkidfuncionario int not null,
	foreign key (fkidcliente) references tb_cliente(pkidcliente) on delete cascade,
    foreign key (fkidfuncionario) references tb_funcionario(pkidfuncionario)
)engine InnoDB;

create table tb_itemvenda(
	fkidvenda int not null,
    fkidproduto int not null,
    foreign key (fkidvenda) references tb_venda(pkidvenda) on delete cascade,
    foreign key (fkidproduto) references tb_produto(pkidproduto)on delete cascade,
    primary key (fkidvenda,fkidproduto)
)engine InnoDB;

create table tb_wishlist(
	pkidwishlist int primary key not null auto_increment,
    quantidade int not null,
    nome varchar(45) not null,
    tb_cliente_pkidcliente int not null,
    foreign key (tb_cliente_pkidcliente) references tb_cliente(pkidcliente)
)engine InnoDB;

create table tb_wishlist_has_tb_produto(
tb_wishlist_pkidwishlist int not null,
tb_produto_pkidproduto int not null,
foreign key (tb_wishlist_pkidwishlist) references tb_wishlist(pkidwishlist) on delete cascade,
foreign key (tb_produto_pkidproduto) references tb_produto(pkidproduto) on delete cascade
)engine InnoDB;

insert into tb_cliente (nome, cpf)
	values('Anderson', 12345678910),
		  ('Leonardo',10987654321),
          ('Juca',12345678944), 
		  ('Sergio', 88823498713),
	      ('Laura', 72763607624),
	      ('Ivo', 32476509842),
	      ('Maristela', 34698754609);
          
insert into tb_cargo (nome, salario)
	values('Vendedor', 1000),
		  ('Gerente',4000);
          
insert into tb_fornecedor (nome, cnpj)
	values('Adopet LTDA.', 1234567891053),
		  ('PetFinder LTDA',1098765432142),
          ('PetCustoms LTDA',5243635563765);
          
insert into tb_funcionario (nome, cpf,fkidcargo)
	values('Nicolas', 73564728372,2),
		  ('Iago',32416389536,1),
          ('Marcelinho',32416353535,1);
       
          
          
insert into tb_contato(telefone,email,fkidcliente,fkidfuncionario,fkidfornecedor)
	values('51991296924',null,1,null,null),
		  ('54992456734','leonardo@hotmail.com',2,null,null),
          ('51999690467','andersonchoren@gmail.com',1,null,null),
          ('21998712389','juca@outlook.com',3,null,null),
          ('55991356478','sergio@yahoo.com.br',4,null,null),
          ('51999997789','laura@qi.edu.br',5,null,null),
          ('51998123456',null,6,null,null),
          ('54999868946','maristela@gmail.com',7,null,null),
          ('51735745857','nicolas@loja.com.br',null,1,null),
          ('51534728367','iago@loja.com.br',null,2,null),
          ('51735745857','marcelinho@loja.com.br',null,3,null),
          ('51534728367','marcelinho@gmail.com',null,3,null),
          ('11999456378','adopet@adopet.com.br',null,null,1),
          ('21996127536','petfinder@petfinder.com.br',null,null,2),
          ('51996273654','petcustoms@petcustoms.com.br',null,null,3);

insert into tb_endereco(rua,numero,bairro,fkidcliente,fkidfuncionario,fkidfornecedor)
	values('Paraíba',358,'Neópolis',1,null,null),
          ('Dorival',1230,'Águas Claras',1,null,null),
          ('Jervásio',134,'Centro',2,null,null),
          ('Pátria',100,'Morada do Vale II',3,null,null),
          ('Independência',500,'Centro',4,null,null),
          ('Flores da Cunha',1366,'Parque Brasilia',5,null,null),
          ('Gravataí',334,'Eunice',6,null,null),
          ('Rio Grande',135,'Passo do Hilário',7,null,null),
          ('Bogotá',45,'Neópolis',2,null,null),
          ('Anápio',156,'Centro',null,1,null),
          ('Juca Batista',278,'Sarandi',null,2,null),
          ('Assis Brasil',444,'Cristo Redentor',null,3,null),
          ('Assis Brasil',3312,'Lindóia',null,1,null),
          ('Marques',122,'',null,null,1),
          ('Pernambuco',359,'Parque des Avenidas',null,null,2),
          ('São Paulo',109,'Itacolomi',null,null,3);
          
insert into tb_produto(nome,valor,fkidfornecedor)
	values('Ração Golden Special para Cães 15 kg',99.90,1),
		  ('Ração Úmida Whiskas Sachê para Gatos 85g',4.90,1),
		  ('Rastreador GPS para animais de estimação',134.90,2),
		  ('Roupinha para Cachorro - Casaquinho com Forro',24.90,3),
          ('Coleira Peitoral Para Cães e Gatos Refletiva',35.90,3);
          
insert into tb_venda(total,fkidcliente,fkidfuncionario)
	values (10,1,2),
		   (55,1,3),
           (30,2,2),
           (100,3,3),
           (60,4,3),
           (80,5,2),
           (65,6,3),
           (90,7,2),
           (120,1,2);
           
insert into tb_itemvenda(fkidvenda,fkidproduto)
	values(1,2),
		  (2,2),
          (3,2),
          (4,3),
          (5,4),
          (6,5),
          (6,3),
          (6,4),
          (7,2),
          (8,3),
          (8,4),
          (8,5),
          (8,2),
          (9,2),
          (9,3); 