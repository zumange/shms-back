CREATE TYPE public.device_type AS ENUM
    ('LIGHT', 'THERMOSTAT', 'CAMERA', 'BLINDS');

ALTER TYPE public.device_type
    OWNER TO postgres;

CREATE TYPE public.thermostats_mode AS ENUM
    ('HEATING', 'COOLING', 'OFF');

ALTER TYPE public.thermostats_mode
    OWNER TO postgres;


CREATE TABLE IF NOT EXISTS public.device
(
    id bigint NOT NULL DEFAULT nextval('device_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT device_pkey PRIMARY KEY (id),
    CONSTRAINT unique_device_name UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.device
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.light
(
    device_id bigint NOT NULL,
    state boolean,
    brightness integer,
    CONSTRAINT light_pkey PRIMARY KEY (device_id),
    CONSTRAINT light_device_id_fkey FOREIGN KEY (device_id)
        REFERENCES public.device (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT light_brightness_check CHECK (brightness >= 0 AND brightness <= 100)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.light
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.thermostat
(
    device_id bigint NOT NULL,
    temperature double precision,
    mode character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT thermostat_pkey PRIMARY KEY (device_id),
    CONSTRAINT thermostat_device_id_fkey FOREIGN KEY (device_id)
        REFERENCES public.device (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.thermostat
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.camera
(
    device_id bigint NOT NULL,
    state boolean,
    recording boolean,
    CONSTRAINT camera_pkey PRIMARY KEY (device_id),
    CONSTRAINT camera_device_id_fkey FOREIGN KEY (device_id)
        REFERENCES public.device (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.camera
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.blinds
(
    device_id bigint NOT NULL,
    state boolean,
    "position" integer,
    CONSTRAINT blinds_pkey PRIMARY KEY (device_id),
    CONSTRAINT blinds_device_id_fkey FOREIGN KEY (device_id)
        REFERENCES public.device (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT blinds_position_check CHECK ("position" >= 0 AND "position" <= 100)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.blinds
    OWNER to postgres;