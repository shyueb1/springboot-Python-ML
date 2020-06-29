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
user = int(sys.argv[1])
print(DB.getAllHealthRecords(user))
DB.closeConnection()


# def normaliseData():
#     pass
# def getPrediction():
#     pass



# nn = new NearestNeighbour()
