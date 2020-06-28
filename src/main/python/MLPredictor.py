"""
    -Connect to DB
    -Get username argument
    -Get user healthrecords
    -Normalise data, apply NN on test sample (todays healthrecord)
    -Return prediction
"""

import sys
import psycopg2
from decouple import config

DB_NAME = config("DB_NAME")
DB_HOST = config("DB_HOST")
DB_USER = config("DB_USER")
DB_PASS = config("DB_PASS")


def connectToDB():
    pass
def getHealthRecord():
    pass
def normaliseData():
    pass
def getPrediction():
    pass

user = sys.argv[1]
# db = new Database()
# nn = new NearestNeighbour()

