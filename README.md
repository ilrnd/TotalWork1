**Операционные системы и виртуализация (Linux)**
1. Использование команды cat в Linux
   - Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.
   - Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
   - Переименовать получившийся файл в "Human Friends"(.
Пример конечного вывода после команды “ls” :
Desktop Documents Downloads  HumanFriends.txt  Music  PackAnimals.txt  Pets.txt  Pictures  Videos

В терминале вводим следующую команду:
```
cat >Pets.txt
```
Создается новый файл Pets, наполняем файл значениями в терминале:
```
dog
cat
hamster
```
Далее нажимаем *Ctrl+D*
Аналогично:
```
cat >PackAnimals.txt
```
Создается новый файл `PackAnimals`, наполняем файл значениями в терминале:
```
horse
camel
donkey
```
Проверяем содержимое корневого каталога командой ls
`ls`
![9ee27bd26a69f83ee4866d5e97485c33.png](../main/_resources/9ee27bd26a69f83ee4866d5e97485c33.png)
Объединяем два файла в один и записываем данные в файл HumanFriends:
```
cat Pets PackAnimals >HumanFriends.txt
ls
```
![805222410bb2a05527fa6870419f9ff4.png](../main/_resources/805222410bb2a05527fa6870419f9ff4.png)
Проверим содержимое файла:
![190f2b3dd53320ca2d65a19a536d5c3d.png](../main/_resources/190f2b3dd53320ca2d65a19a536d5c3d.png)

2. Работа с директориями в Linux
   - Создать новую директорию и переместить туда файл "Human Friends".
```
mkdir animals
mv HumanFriends.txt animals/
cd animals/
ls
```
![3b87ae6d7c4aa88ea32a582c038f16a0.png](../main/_resources/3b87ae6d7c4aa88ea32a582c038f16a0.png)
3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
- Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.
`- sudo apt install mysql-server mysql-client`
![f5978fc998e7e950904d9fedc19c6c5b.png](../main/_resources/f5978fc998e7e950904d9fedc19c6c5b.png)
4. Управление deb-пакетами
5. - Установить и затем удалить deb-пакет, используя команду `dpkg`.
Скачиваем deb пакет. Для примера установим mysql-connector:
`dpkg -i mysql-connector-j_8.1.0-1ubuntu22.04_all.deb`
![6a2bd647338101289658e5dc366dd0a4.png](../main/_resources/6a2bd647338101289658e5dc366dd0a4.png)
5. История команд в терминале Ubuntu
   - Сохранить и выложить историю ваших терминальных команд в Ubuntu.
В формате: Файла с ФИО, датой сдачи, номером группы(или потока)
Последние команды в терминале можно посмотреть командой
history

**Объектно-ориентированное программирование**
6. Диаграмма классов
   - Создать диаграмму классов с родительским классом "Животные", и двумя подклассами: "Pets" и "Pack animals".
В составы классов которых в случае Pets войдут классы: собаки, кошки, хомяки, а в класс Pack animals войдут: Лошади, верблюды и ослы).
Каждый тип животных будет характеризоваться (например, имена, даты рождения, выполняемые команды и т.д)
Диаграмму можно нарисовать в любом редакторе, такими как Lucidchart, Draw.io, Microsoft Visio и других.

7. Работа с MySQL (Задача выполняется в случае успешного выполнения задачи “Работа с MySQL в Linux. “Установить MySQL на вашу машину”

7.1. После создания диаграммы классов в 6 пункте, в 7 пункте база данных "Human Friends" должна быть структурирована в соответствии с этой диаграммой. Например, можно создать таблицы, которые будут соответствовать классам "Pets" и "Pack animals", и в этих таблицах будут поля, которые характеризуют каждый тип животных (например, имена, даты рождения, выполняемые команды и т.д.). 
7.2   - В ранее подключенном MySQL создать базу данных с названием "Human Friends".
   - Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
   - Заполнить таблицы данными о животных, их командах и датами рождения.
   - Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
   - Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
   - Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.
 
```
DROP DATABASE IF EXISTS human_friends;
```
-- Создание базы данных
```
CREATE DATABASE human_friends;
USE human_friends;
-- Создание таблицы класса животных
DROP TABLE IF EXISTS animals_base;
CREATE TABLE animals_base
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30)
);
```
-- Создание таблицы рода животных
```
DROP TABLE IF EXISTS animal_genus;
CREATE TABLE animal_genus
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30),
    group_id INT,
    FOREIGN KEY (group_id) REFERENCES animals_base (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);
```

-- Создание таблицы экземпляров животых
```
DROP TABLE IF EXISTS animals;
CREATE TABLE animals
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30),
    genus_id INT,
    birth_date DATE,
    FOREIGN KEY (genus_id) REFERENCES animal_genus (id) -- связь по внешнему ключу
    ON DELETE CASCADE ON UPDATE CASCADE
);
```

-- Создание таблицы команды
```
DROP TABLE IF EXISTS commands;
CREATE TABLE commands
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30)
);
```

-- Создание таблицы для связи команд и животных
```
DROP TABLE IF EXISTS animal_commands;
CREATE TABLE animal_commands
(
    animal_id INT NOT NULL,
    command_id INT NOT NULL,

    PRIMARY KEY (animal_id, command_id),
    FOREIGN KEY (animal_id) REFERENCES animals (id)
     ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (command_id) REFERENCES commands (id)
     ON DELETE CASCADE  ON UPDATE CASCADE
);
```

-- Заполнение таблиц.
```
INSERT INTO animals_base (name)
VALUES
	 ('Pack animals'),
	 ('Pets');
     
INSERT INTO animal_genus (name, group_id)
VALUE
	('Dog', 2),
    ('Cat', 2),
    ('Hamster', 2),
    ('Horse', 1),
    ('Camel', 1),
    ('Donkey', 1);
SELECT * FROM animal_genus;    

INSERT INTO commands (name)
VALUE
	('Sit'),
    ('Stay'),
    ('Fetch'),
    ('Pounce'),
    ('Roll'),
    ('Hide'),
    ('Paw'),
    ('Bark'),
    ('Spin'),
    ('Scratch'),
    ('Meow'),
    ('Jump'),
    ('Trot'),
    ('Canter'),
    ('Gallop'),
    ('Walk'),
    ('Carry load'),
    ('Bray'),
    ('Kick'),
    ('Run');
    
INSERT INTO animals (name, birth_date, genus_id)
VALUE
	('Fido', '2020-01-01', 1),
    ('Whiskers', '2019-05-15', 2),
    ('Hammy', '2021-03-10', 3),
    ('Buddy',  '2018-12-10', 1),
    ('Smudge','2020-02-20', 2),
    ('Peanut','2021-08-01',3),
    ('Bella', '2019-11-11', 1),
    ('Oliver',  '2020-06-30', 2),
    ('Thunder', '2015-07-21', 4),
    ('Sandy',  '2016-11-03',  5),
    ('Eeyore', '2017-09-18', 6),
    ('Storm','2014-05-05',  4),
    ('Dune', '2018-12-12', 5),
    ('Burro', '2019-01-23', 6),
    ('Blaze', '2016-02-29', 4),
    ('Sahara', '2015-08-14', 5);
```
    
 -- Заполняем таблицу связи животных с коммандами
 ```
INSERT INTO animal_commands(animal_id, command_id)
 VALUE
 (1, 1), (1, 2), (1, 3),
 (2, 1), (2, 4),
 (3, 5), (3, 6),
 (4, 1), (4, 7), (4, 8),
 (5, 1), (5, 4), (5,10),
 (6, 5), (6, 9),
 (7, 1), (7, 2), (7, 5),
 (8, 11), (8, 10), (8, 12),
 (9, 13), (9, 14), (9, 15),
 (10, 16), (10, 17),
 (11, 16), (11, 17), (11, 18),
 (12, 13), (12, 14),
 (13, 16), (13, 1),
 (14, 16), (14, 18), (14, 19),
 (15, 13), (15, 12), (15, 15),
 (16, 16), (16, 20)
 ;
```
    
-- Итоговая таблица с животными    

```
SELECT  animals.id, animals.name, animal_genus.name AS type, animals.birth_date, 
GROUP_CONCAT(commands.name)  AS commands
FROM animals
JOIN
animal_genus 
ON 
animals.genus_id=animal_genus.id
LEFT JOIN
animal_commands 
ON 
animal_commands.animal_id=animals.id
LEFT JOIN
commands
ON
commands.id=animal_commands.command_id
GROUP BY animals.id;
```

-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
```
USE human_friends;
DELETE FROM animals WHERE animals.genus_id=5;
DROP TABLE IF EXISTS HorseDonkey;
CREATE TABLE HorseDonkey AS
SELECT * FROM animals WHERE animals.genus_id=4
UNION
SELECT * FROM animals WHERE animals.genus_id=6; 

SELECT * FROM HorseDonkey;
```

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет 
-- и вычислить их возраст с точностью до месяца.
```
USE human_friends;
DROP TABLE IF EXISTS animals_1_3;
CREATE TABLE animals_1_3 AS
SELECT
*, TIMESTAMPDIFF(MONTH, birth_date, curdate()) AS age_months
FROM
animals;
```

```
SELECT * FROM animals_1_3;
```
 
-- Объединить все созданные таблицы в одну, 
-- сохраняя информацию о принадлежности к исходным таблицам.

```
USE human_friends;
DROP TABLE IF EXISTS animals_total;
CREATE TABLE animals_total AS
SELECT id, name, genus_id, birth_date FROM HorseDonkey
UNION
SELECT id, name, genus_id, birth_date FROM animals_1_3
ORDER BY
id;
```

SELECT * FROM animals_total;