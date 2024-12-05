INSERT INTO public.device (name, type) VALUES
('Light1', 'LIGHT'),
('Light2', 'LIGHT'),
('Light3', 'LIGHT');

INSERT INTO public.light (device_id, state, brightness) VALUES
((SELECT id FROM public.device WHERE name = 'Light1'), TRUE, 80),
((SELECT id FROM public.device WHERE name = 'Light2'), FALSE, 50),
((SELECT id FROM public.device WHERE name = 'Light3'), TRUE, 100);


INSERT INTO public.device (name, type) VALUES
('Thermostat1', 'THERMOSTAT'),
('Thermostat2', 'THERMOSTAT'),
('Thermostat3', 'THERMOSTAT');

INSERT INTO public.thermostat (device_id, temperature, mode) VALUES
((SELECT id FROM public.device WHERE name = 'Thermostat1'), 22.5, 'HEATING'),
((SELECT id FROM public.device WHERE name = 'Thermostat2'), 21.0, 'COOLING'),
((SELECT id FROM public.device WHERE name = 'Thermostat3'), 19.0, 'OFF');


INSERT INTO public.device (name, type) VALUES
('Camera1', 'CAMERA'),
('Camera2', 'CAMERA'),
('Camera3', 'CAMERA');

INSERT INTO public.camera (device_id, state, recording) VALUES
((SELECT id FROM public.device WHERE name = 'Camera1'), TRUE, FALSE),
((SELECT id FROM public.device WHERE name = 'Camera2'), FALSE, TRUE),
((SELECT id FROM public.device WHERE name = 'Camera3'), TRUE, TRUE);


INSERT INTO public.device (name, type) VALUES
('Blinds1', 'BLINDS'),
('Blinds2', 'BLINDS'),
('Blinds3', 'BLINDS');

INSERT INTO public.blinds (device_id, state, "position") VALUES
((SELECT id FROM public.device WHERE name = 'Blinds1'), TRUE, 75),
((SELECT id FROM public.device WHERE name = 'Blinds2'), FALSE, 40),
((SELECT id FROM public.device WHERE name = 'Blinds3'), TRUE, 60);
