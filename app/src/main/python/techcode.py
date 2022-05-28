from os.path import dirname ,join
import numpy as np
import pandas as pd
def tech(num1,num2,num3):
    filename=join(dirname(__file__),"libs2/cars_engage_2022(2).csv")
    df=pd.read_csv(filename)
    a=int(num1)
    b=(num2)
    c=(num3)
    XD=df[(df['City_Mileage']>=a)&(df['Fuel_Type']==c)&(df['Type']==b)]
    ZD=XD.reset_index()
    return(ZD[['Make','Model','Ex-Showroom_Price']])