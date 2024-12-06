DROP TABLE IF EXISTS public.device CASCADE
;

DROP TABLE IF EXISTS public.light CASCADE
;

DROP TABLE IF EXISTS public.thermostat CASCADE
;

DROP TABLE IF EXISTS public.camera CASCADE
;

DROP TABLE IF EXISTS public.blinds CASCADE
;

CREATE TABLE public.device
(
    id bigserial NOT NULL,
    name varchar(40) NOT NULL,
    type varchar(20) NOT NULL,
    CONSTRAINT device_pkey PRIMARY KEY (id),
    CONSTRAINT unique_device_name UNIQUE (name)
)
;

CREATE TABLE public.light
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
;

CREATE TABLE public.thermostat
(
    device_id bigint NOT NULL,
    temperature double precision,
    mode varchar(20),
    CONSTRAINT thermostat_pkey PRIMARY KEY (device_id),
    CONSTRAINT thermostat_device_id_fkey FOREIGN KEY (device_id)
        REFERENCES public.device (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
;

CREATE TABLE public.camera
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
;

CREATE TABLE public.blinds
(
    device_id bigint NOT NULL,
    state boolean,
    position integer,
    CONSTRAINT blinds_pkey PRIMARY KEY (device_id),
    CONSTRAINT blinds_device_id_fkey FOREIGN KEY (device_id)
        REFERENCES public.device (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT blinds_position_check CHECK (position >= 0 AND position <= 100)
)
;