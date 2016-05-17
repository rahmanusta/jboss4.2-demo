-- Table: public.hedgehog

-- DROP TABLE public.hedgehog;

CREATE TABLE public.hedgehog
(
  id bigint NOT NULL DEFAULT nextval('hedgehog_id_seq'::regclass),
  name character varying(255),
  CONSTRAINT hedgehog_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.hedgehog
  OWNER TO postgres;
