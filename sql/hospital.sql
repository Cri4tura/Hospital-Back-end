drop database if exists hospital_whobranch;
create database hospital_whobranch;
use hospital_whobranch;

INSERT INTO patient (name, surname, birth_date, password, email, direction, language, medical_history, allergies, caregiver, hygiene) VALUES
('Michael', 'Harris', '1990-02-20', 'password1', 'michael.harris@example.com', '123 Main St', 'English', 'Asthma', 'Peanuts', 'John Doe', 'Good'),
('Sarah', 'Clark', '1985-03-15', 'password2', 'sarah.clark@example.com', '456 Elm St', 'Spanish', 'Diabetes', 'None', 'Jane Doe', 'Excellent'),
('David', 'Lewis', '1978-07-07', 'password3', 'david.lewis@example.com', '789 Oak St', 'English', 'Heart Disease', 'None', 'John Doe', 'Poor'),
('Emma', 'Walker', '1992-01-01', 'password4', 'emma.walker@example.com', '101 Pine St', 'French', 'Chronic Cough', 'None', 'Jane Doe', 'Fair'),
('Olivia', 'Hall', '2000-05-16', 'password5', 'olivia.hall@example.com', '202 Birch St', 'English', 'High Blood Pressure', 'None', 'John Doe', 'Good'),
('James', 'Allen', '1982-11-12', 'password6', 'james.allen@example.com', '303 Cedar St', 'German', 'Cancer', 'None', 'Jane Doe', 'Excellent'),
('Isabella', 'Young', '1995-09-28', 'password7', 'isabella.young@example.com', '404 Maple St', 'Spanish', 'Obesity', 'None', 'John Doe', 'Good'),
('Liam', 'King', '1987-04-18', 'password8', 'liam.king@example.com', '505 Fir St', 'English', 'Chronic Back Pain', 'None', 'Jane Doe', 'Fair'),
('Mason', 'Scott', '1998-03-30', 'password9', 'mason.scott@example.com', '606 Cedar St', 'English', 'Migraine', 'None', 'John Doe', 'Poor'),
('Sophia', 'Green', '1989-12-22', 'password10', 'sophia.green@example.com', '707 Pine St', 'French', 'Arthritis', 'None', 'Jane Doe', 'Good');

-- Inserts para la tabla Nurse
INSERT INTO nurse (name, surname, birth_date, password, email) VALUES 
('Alice', 'Johnson', '1985-06-15', 'password1', 'alice.johnson@example.com'),
('Bob', 'Smith', '1980-09-22', 'password2', 'bob.smith@example.com'),
('Charlie', 'Brown', '1992-01-10', 'password3', 'charlie.brown@example.com'),
('David', 'White', '1975-04-30', 'password4', 'david.white@example.com'),
('Emma', 'Taylor', '1990-12-05', 'password5', 'emma.taylor@example.com'),
('Frank', 'Harris', '1988-08-19', 'password6', 'frank.harris@example.com'),
('Grace', 'Clark', '1995-03-25', 'password7', 'grace.clark@example.com'),
('Henry', 'Lewis', '1982-07-14', 'password8', 'henry.lewis@example.com'),
('Isabella', 'Walker', '1993-11-08', 'password9', 'isabella.walker@example.com'),
('Jack', 'Hall', '1987-05-21', 'password10', 'jack.hall@example.com');

-- Inserts para la tabla Patient
INSERT INTO patient (name, surname, birth_date, password, email, direction, language, medical_history, allergies, caregiver, hygiene) VALUES 
('Sophia', 'Martinez', '1970-07-10', 'password1', 'sophia.martinez@example.com', '123 Main St', 'English', 'Diabetes', 'Peanuts', 'John Doe', 'Daily'),
('Liam', 'Garcia', '1985-02-20', 'password2', 'liam.garcia@example.com', '456 Oak St', 'Spanish', 'Hypertension', 'None', 'Jane Doe', 'Weekly'),
('Olivia', 'Rodriguez', '1990-10-05', 'password3', 'olivia.rodriguez@example.com', '789 Pine St', 'French', 'Asthma', 'Shellfish', 'Sarah Doe', 'Daily'),
('Noah', 'Lopez', '1982-05-14', 'password4', 'noah.lopez@example.com', '321 Birch St', 'English', 'Cancer', 'None', 'Mike Doe', 'Weekly'),
('Emma', 'Hernandez', '1978-09-25', 'password5', 'emma.hernandez@example.com', '654 Cedar St', 'German', 'Arthritis', 'Dairy', 'Anna Doe', 'Daily'),
('Aiden', 'Perez', '1995-11-11', 'password6', 'aiden.perez@example.com', '987 Maple St', 'English', 'Anemia', 'Gluten', 'Lucy Doe', 'Weekly'),
('Mia', 'Gonzalez', '1989-03-30', 'password7', 'mia.gonzalez@example.com', '741 Elm St', 'Italian', 'Epilepsy', 'Nuts', 'Chris Doe', 'Daily'),
('Ethan', 'Ramirez', '1975-06-17', 'password8', 'ethan.ramirez@example.com', '852 Fir St', 'Portuguese', 'Heart Disease', 'None', 'Daniel Doe', 'Weekly'),
('Isabella', 'Torres', '1983-08-22', 'password9', 'isabella.torres@example.com', '963 Walnut St', 'Dutch', 'Allergies', 'Dust', 'Laura Doe', 'Daily'),
('Lucas', 'Flores', '1991-12-09', 'password10', 'lucas.flores@example.com', '147 Cherry St', 'Japanese', 'Migraines', 'None', 'Alex Doe', 'Weekly');

-- Inserts para la tabla Diagnosis
INSERT INTO diagnosis (dependence, O2, diaper, number_of_chronic_diseases) VALUES 
('Low', 'No', FALSE, 1),
('Medium', 'Yes', TRUE, 2),
('High', 'No', FALSE, 3),
('None', 'No', FALSE, 0),
('High', 'Yes', TRUE, 4),
('Low', 'No', FALSE, 1),
('Medium', 'No', FALSE, 2),
('High', 'Yes', TRUE, 5),
('None', 'No', FALSE, 0),
('Medium', 'Yes', TRUE, 3);

-- Inserts para la tabla Mobilization
INSERT INTO mobilization (sitting_type, wandering, wandering_type, postural_change) VALUES 
('Wheelchair', TRUE, 'Occasional', FALSE),
('Bed-bound', FALSE, NULL, TRUE),
('Independent', TRUE, 'Frequent', FALSE),
('Assisted', TRUE, 'Rare', TRUE),
('Bed-bound', FALSE, NULL, FALSE),
('Independent', TRUE, 'Frequent', TRUE),
('Assisted', FALSE, NULL, FALSE),
('Wheelchair', TRUE, 'Occasional', TRUE),
('Bed-bound', FALSE, NULL, TRUE),
('Independent', TRUE, 'Rare', FALSE);

-- Inserts para la tabla Room
INSERT INTO room (name, section) VALUES 
('101', 'A'),
('102', 'A'),
('103', 'B'),
('104', 'B'),
('105', 'C'),
('201', 'C'),
('202', 'D'),
('203', 'D'),
('204', 'E'),
('205', 'E');

-- Inserts para la tabla Care
INSERT INTO care (care_date, care_shift, pulse, temperature, respiration_rate, oxygen_saturation, low_blood_pressure, high_blood_pressure, observations) VALUES 
('2025-02-01', 'Morning', 72, 36.5, 18, 98.0, 80, 120, 'Stable condition'),
('2025-02-02', 'Afternoon', 80, 37.1, 20, 97.5, 85, 125, 'Mild fever'),
('2025-02-03', 'Night', 78, 36.8, 19, 99.0, 82, 118, 'Normal readings'),
('2025-02-04', 'Morning', 76, 36.6, 17, 96.8, 78, 115, 'Low oxygen saturation'),
('2025-02-05', 'Afternoon', 74, 37.0, 16, 97.2, 81, 119, 'Stable condition'),
('2025-02-06', 'Night', 79, 36.9, 18, 98.5, 84, 122, 'Good response to treatment'),
('2025-02-07', 'Morning', 81, 37.2, 21, 97.8, 87, 128, 'Patient coughing'),
('2025-02-08', 'Afternoon', 77, 36.7, 19, 99.2, 83, 117, 'Improved oxygenation'),
('2025-02-09', 'Night', 75, 36.4, 18, 98.9, 79, 113, 'Normal condition'),
('2025-02-10', 'Morning', 82, 37.3, 20, 97.0, 86, 130, 'Increased fever');

-- Inserts para la tabla Drainage
INSERT INTO drainage (drainage_Type, drainage_debit, notes) VALUES 
('Chest Tube', 100.5, 'Fluid clear'),
('Abdominal Drain', 120.0, 'Slightly cloudy'),
('Catheter', 50.0, 'Minimal output'),
('Wound Drain', 90.0, 'No infection signs'),
('Pleural Drain', 110.0, 'High output'),
('Chest Tube', 130.0, 'Blood-tinged fluid'),
('Abdominal Drain', 80.0, 'Steady drainage'),
('Catheter', 40.0, 'No complications'),
('Wound Drain', 70.0, 'Reduced swelling'),
('Pleural Drain', 115.0, 'Monitoring required');

-- Inserts para la tabla Diet
INSERT INTO diet (texture, diet_type, autonomous, prosthesis, diet_consistency, diet_restrictions) VALUES 
('Soft', 'Vegetarian', TRUE, 'No', 'Smooth', 'No nuts'),
('Pureed', 'Vegan', FALSE, 'Yes', 'Liquid', 'No dairy'),
('Normal', 'Regular', TRUE, 'No', 'Firm', 'No seafood'),
('Liquid', 'Diabetic', FALSE, 'Yes', 'Thin', 'Low sugar'),
('Soft', 'Low-Sodium', TRUE, 'No', 'Smooth', 'No salt'),
('Pureed', 'High-Protein', FALSE, 'Yes', 'Liquid', 'Extra protein'),
('Normal', 'Low-Fat', TRUE, 'No', 'Firm', 'No fried food'),
('Liquid', 'Renal', FALSE, 'Yes', 'Thin', 'Low potassium'),
('Soft', 'Bland', TRUE, 'No', 'Smooth', 'No spices'),
('Pureed', 'Gluten-Free', FALSE, 'Yes', 'Liquid', 'No wheat');


#ALTER TABLE patient DROP COLUMN id_patient;
#ALTER TABLE patient DROP FOREIGN KEY FKdgwpnvgca5hwe67ukgp8w1mdp;

Select * from room;
Select * from patient;
select * from mobilization;
select * from care;
select * from diagnosis;
select * from diet;
select * from nurse;