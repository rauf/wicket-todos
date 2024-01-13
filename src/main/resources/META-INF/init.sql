INSERT INTO properties(id, name, created_at, updated_at) VALUES (1, 'Burj Khalifa', now(), now());
INSERT INTO properties(id, name, created_at, updated_at) VALUES (2, 'Burj Al Arab', now(), now());
INSERT INTO properties(id, name, created_at, updated_at) VALUES (3, 'Kingdom Tower', now(), now());
INSERT INTO properties(id, name, created_at, updated_at) VALUES (4, 'Dubai Mall', now(), now());

INSERT INTO users(id, name, email, created_at, updated_at) VALUES (1, 'Abdul', 'abdul@test.com', now(), now());
INSERT INTO users(id, name, email, created_at, updated_at) VALUES (2, 'Robert', 'robert@test.com', now(), now());
INSERT INTO users(id, name, email, created_at, updated_at) VALUES (3, 'Sylvain', 'sylvain@test.com', now(), now());

INSERT INTO tasks (id, name, priority, status, assigned_to, due_date, created_at, updated_at, property_id) VALUES (1, 'Cleaning the facade', 'MEDIUM', 'TODO', 1, '2024-01-01', now(), now(), 1);
INSERT INTO tasks (id, name, priority, status, assigned_to, due_date, created_at, updated_at, property_id) VALUES (2, 'Renewing the fire extinguishers', 'HIGH', 'COMPLETED', 2, '2024-01-03', now(), now(), 1);
INSERT INTO tasks (id, name, priority, status, assigned_to, due_date, created_at, updated_at, property_id) VALUES (3, 'Fixing some defects', 'LOW', 'ON_HOLD', 2, '2024-01-06', now(), now(), 2);
INSERT INTO tasks (id, name, priority, status, assigned_to, due_date, created_at, updated_at, property_id) VALUES (4, 'Clean the windows', 'LOW', 'IN_PROGRESS', 2, '2024-01-11', now(), now(), 3);
INSERT INTO tasks (id, name, priority, status, assigned_to, due_date, created_at, updated_at, property_id) VALUES (5, 'Clean the floor', 'LOW', 'IN_PROGRESS', 3, '2024-02-01', now(), now(), 4);
