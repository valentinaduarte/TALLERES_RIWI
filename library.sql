CREATE DATABASE library;
USE library;

-- Create the Authors table
CREATE TABLE authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(100) NOT NULL
);

-- Create the Books table
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    publication_year INT NOT NULL,
    price DECIMAL(15, 2) NOT NULL,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

-- Insert data into the Authors table
INSERT INTO Authors (name, nationality) VALUES
('Gabriel Garcia Marquez', 'Colombian'),
('Mario Vargas Llosa', 'Peruvian'),
('Jorge Luis Borges', 'Argentinian'),
('Julio Cortazar', 'Argentinian'),
('Isabel Allende', 'Chilean'),
('Pablo Neruda', 'Chilean'),
('Fernando Pessoa', 'Portuguese'),
('Clarice Lispector', 'Brazilian'),
('Garcia Lorca', 'Spanish'),
('Miguel de Cervantes', 'Spanish'),
('Jane Austen', 'British'),
('William Shakespeare', 'British'),
('Fyodor Dostoevsky', 'Russian'),
('Leo Tolstoy', 'Russian'),
('Mark Twain', 'American'),
('Ernest Hemingway', 'American'),
('Franz Kafka', 'Austrian'),
('Hermann Hesse', 'German'),
('J.K. Rowling', 'British'),
('Agatha Christie', 'British'),
('Haruki Murakami', 'Japanese'),
('Yukio Mishima', 'Japanese'),
('Octavio Paz', 'Mexican'),
('Carlos Fuentes', 'Mexican');


-- Insert data into the Books table
INSERT INTO Books (title, publication_year, price, author_id) VALUES
('One Hundred Years of Solitude', 1967, 20.99, 1),
('The House of the Spirits', 1982, 15.50, 5),
('Don Quixote', 1605, 12.75, 10),
('The Aleph', 1949, 18.00, 3),
('Hopscotch', 1963, 14.25, 4),
('One Hundred Years of Solitude', 1967, 20.99, 1),
('Love in the Time of Cholera', 1985, 16.80, 1),
('The Time of the Hero', 1963, 13.45, 2),
('Ficciones', 1944, 19.20, 3),
('The Savage Detectives', 1998, 22.50, 4),
('The House of Bernarda Alba', 1936, 11.25, 9),
('Romeo and Juliet', 1597, 10.99, 12),
('Pride and Prejudice', 1813, 9.75, 11),
('Crime and Punishment', 1866, 17.30, 13),
('War and Peace', 1869, 21.60, 14),
('To Kill a Mockingbird', 1960, 14.99, 15),
('The Old Man and the Sea', 1952, 12.50, 16),
('The Metamorphosis', 1915, 11.80, 18),
('The Stranger', 1942, 13.25, 18),
('Harry Potter and the Philosopher''s Stone', 1997, 18.99, 19),
('Murder on the Orient Express', 1934, 15.25, 20),
('1Q84', 2009, 24.00, 21),
('The Sound of Waves', 1954, 12.75, 22),
('Sunstone', 1957, 11.50, 23),
('Aura', 1962, 13.20, 24);

-- Mostrar
SELECT * FROM authors;
SELECT * FROM books;
