import psycopg2
import os

class Database:
    def __init__(self):
        #access env variables
        self.DB_NAME = os.getenv("DB_NAME")
        self.DB_HOST = os.getenv("DB_HOST")
        self.DB_USER = os.getenv("DB_USER")
        self.DB_PASS = os.getenv("DB_PASS")
        self.connection = None
        try:
            self.connection = self.connectToDB()
        except (Exception, psycopg2.DatabaseError) as error:
            print(error)

    def connectToDB(self):
        self.connection = psycopg2.connect(
            host=self.DB_HOST, 
            user=self.DB_USER,
            password=self.DB_PASS,
            database=self.DB_NAME,
        )
        return self.connection.cursor()
    
    def query(self, query):
        try:
            self.connection.execute(query)
            return self.connection.fetchall()
        except (Exception, psycopg2.ProgrammingError) as error:
            print(error)
            return None

    def getAllHealthRecords(self, user):
        return self.query(f"SELECT * FROM healthrecord WHERE user_name='{user}';")
    
    def getUser(self, user):
        return self.query(f"SELECT * FROM userp WHERE user_name='{user}';")


    def closeConnection(self):
        if self.connection is not None:
            self.connection.close()
        return