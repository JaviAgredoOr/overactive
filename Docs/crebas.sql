/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     9/09/2021 1:13:58 a. m.                      */
/*==============================================================*/


drop table CUSTOMERS;

drop table PURCHASES;

drop table STRATEGIES;

/*==============================================================*/
/* Table: CUSTOMERS                                             */
/*==============================================================*/
create table CUSTOMERS (
   CUSTOMER_ID          SERIAL               not null,
   NAME                 TEXT                 not null,
   constraint PK_CUSTOMERS primary key (CUSTOMER_ID)
);

/*==============================================================*/
/* Table: PURCHASES                                             */
/*==============================================================*/
create table PURCHASES (
   CUSTOMER_ID          INT4                 null,
   PURCHASE_ID          SERIAL               not null,
   TOTAL                FLOAT4               null,
   DATE                 DATE                 null,
   constraint PK_PURCHASES primary key (PURCHASE_ID)
);

/*==============================================================*/
/* Table: STRATEGIES                                            */
/*==============================================================*/
create table STRATEGIES (
   STRATEGY_ID          SERIAL               not null,
   LOWER_LIMIT          FLOAT4               null,
   UPPER_LIMIT          FLOAT4               null,
   POINTS               INT2                 null,
   constraint PK_STRATEGIES primary key (STRATEGY_ID)
);

alter table PURCHASES
   add constraint FK_PURCHASE_REFERENCE_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMERS (CUSTOMER_ID)
      on delete restrict on update restrict;

