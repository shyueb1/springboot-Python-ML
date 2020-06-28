"""
    -Connect to DB
    -Get username argument
    -Get user healthrecords
    -Normalise data, apply NN on test sample (todays healthrecord)
    -Return prediction
"""

import sys
from Database import Database
from Setup import Setup

Setup()
DB = Database()
user = sys.argv[1]
print(DB.getUser(user))


# def getAllHealthRecord(user):
#     pass
# def normaliseData():
#     pass
# def getPrediction():
#     pass



# nn = new NearestNeighbour()



# try:
# close the communication with the PostgreSQL
# cur.close()
# execute a statement
# print('PostgreSQL database version:')
# DB.execute('SELECT version()')
# db_version = DB.fetchone()
# print(db_version)