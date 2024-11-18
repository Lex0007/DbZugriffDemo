# Dokumentation der Methoden

## selectAllDemo()
Zeigt alle Datensätze der Tabelle `student` an.

SQL Aufruf: `SELECT * FROM student`

## insertStudentDemo(String name, String email)
Fügt einen neuen Studenten mit dem angegebenen Namen und der E-Mail in die Tabelle student ein.

SQL Aufruf: `INSERT INTO student (id, name, email) VALUES (NULL, ?, ?)`

## updateStudentDemo(int id, String neuerName, String neueEmail)
Aktualisiert den Namen und die E-Mail eines Studenten basierend auf der angegebenen ID.

SQL Aufruf: `UPDATE student SET name = ?, email = ? WHERE student.id = ?`

## deletStudentDemo(int studentId)
Löscht den Datensatz eines Studenten basierend auf der angegebenen ID.

SQL Aufruf: `DELETE FROM student WHERE student.id = ?`

## findAllByNameLike(String pattern)
Sucht nach allen Studenten, deren Name dem angegebenen Muster entspricht (LIKE-Abfrage).

SQL Aufruf: `SELECT * FROM student WHERE student.name LIKE ?`