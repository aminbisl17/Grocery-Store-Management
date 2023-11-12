from mysql import connector

db = connector.connect(
    host="localhost",
    user="root",
    passwd="admin",
    database="pytest"
)


myCursor = db.cursor()

myCursor.execute("SELECT name FROM admin")

name = myCursor.fetchone()[0]

myCursor.close()
db.close()

print(name)