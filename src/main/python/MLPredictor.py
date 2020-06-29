"""
TODO:
    -Normalise data, cross_validation, grid_search, apply NN on test sample (todays healthrecord)
    -Return prediction
"""


from Database import Database
from Setup import Setup

import sys
import numpy as np
import datetime


def normaliseDatatypes(dataTypeMap, sample_data):
        data_type_normalised = []
        for sample in sample_data:
            sample_transformed = []
            for data in sample:
                if type(data) != float:
                    sample_transformed.append(dataTypeMap[data])
                else:
                    sample_transformed.append(data)
            data_type_normalised.append(sample_transformed)
        return data_type_normalised

def normaliseData():
    pass

def getPrediction():
    pass
        
SAMPLE_DATA = [
    (2700.0, True, 'MORNING', 4.0, 100.0), 
    (1800.0, False, 'EVENING', 5.0, 99.0), 
    (2500.0, True, 'MORNING', 5.0, 99.0), 
    (2000.0, False, 'AFTERNOON', 5.0, 99.0),
    (2053.0, False, 'AFTERNOON', 5.0, 99.0), 
    (1994.0, False, 'AFTERNOON', 6.0, 99.0), 
    (1855.0, False, 'EVENING', 4.0, 98.0), 
    (2450.0, True, 'AFTERNOON', 5.0, 99.0),
    (2550.0, True, 'MORNING', 4.0, 99.0), 
    (2800.0, True, 'EVENING', 7.0, 99.0), 
    (1900.0, False, 'AFTERNOON', 5.0, 99.0),
    (1780.0, False, 'AFTERNOON', 5.0, 98.0),
    (2880.0, True, 'MORNING', 4.0, 99.0),
    (2950.0, True, 'MORNING', 5.0, 99.0),
    (1999.0, False, 'AFTERNOON', 5.0, 99.0),
    (1699.0, False, 'AFTERNOON', 5.0, 98.0), 
    (1950.0, False, 'MORNING', 7.0, 98.0), 
    (2440.0, True, 'MORNING', 6.0, 98.0), 
    (2880.0, True, 'MORNING', 5.0, 98.0), 
    (2900.0, True, 'MIDNIGHT', 5.0, 99.0), 
    (2600.0, True, 'MORNING', 5.0, 99.0)
]

data_type_mapping = {
    True: 1,
    False: 0,
    'MORNING': 0,
    'AFTERNOON': 1,
    'EVENING': 2,
    'MIDNIGHT': 3
}

Setup()
DB = Database()
user = int(sys.argv[1])

#Access health records from DB
health_records = DB.getAllHealthRecords(user)
#Make all columns be float equivalents
type_normalised_health_records = normaliseDatatypes(data_type_mapping, SAMPLE_DATA)

DB.closeConnection()
