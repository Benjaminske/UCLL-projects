SET search_path to r1102044;
CREATE TABLE importcsv (
  PK                integer NOT NULL,
  Dexnr                integer NOT NULL,
  Name              varchar(60) NOT NULL,
  Type_1            varchar(50) NOT NULL,
  Type_2            varchar(50),
  Total             integer NOT NULL,
  HP                integer NOT NULL,
  Attack            integer NOT NULL,
  Defence           integer NOT NULL,
  Sp_Atk           integer NOT NULL,
  Sp_Def           integer NOT NULL,
  Speed             integer NOT NULL,
  Generation        integer NOT NULL,
  Legendary 		bool NOT NULL,	
  CONSTRAINT pk_importcsv PRIMARY KEY ( PK )
);