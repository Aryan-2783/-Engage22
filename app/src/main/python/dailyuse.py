from os.path import dirname ,join
import numpy as np
import pandas as pd 
def daily():
    filename=join(dirname(__file__),"libs2/cars_engage_2022(1).csv")
    df=pd.read_csv(filename)
    XD=df[(df['Fuel_Tank_Capacity']>35)&(df['City_Mileage']>25)]
    ZD=XD.reset_index()
    return(ZD[['Make','Model','Variant','Ex-Showroom_Price']])
