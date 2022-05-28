from os.path import dirname ,join
import numpy as np
import pandas as pd
def gego(num1,num2,num3):
    filename=join(dirname(__file__),"libs2/cars_engage_2022(3).csv")
    df=pd.read_csv(filename)
    a=(num1)
    b=(num2)
    c=int(num3)
    if(a=='Rural'):
        if(b=='Mountain'):
            XD=df[(df['Body_Type']=='SUV')&(df['Ground_Clearance']>225)]
        elif(b=='Arid'):
            XD=df[(df['Body_Type']=='Sedan')&(df['Sun_Visor']=='Driver & Front Passenger')&(df['Ground_Clearance']>=170)]
        else:
            XD=df[(df['Body_Type']=='Hatchback')&(df['City_Mileage']>23)]
    elif(a=='Urban'):
        if(b=='Mountain'):
            if(c<3000):
                XD=df[(df['Body_Type']=='SUV')&(df['Ground_Clearance']>225)]
            else:
                XD=df[(df['Body_Type']=='SUV')&(df['Ground_Clearance']>225)&(df['Parking_Assistance']!='')]
        elif(b=='Arid'):
            if(c<3000):
                XD=df[(df['Body_Type']=='Sedan')&(df['Sun_Visor']=='Driver & Front Passenger')&(df['Ground_Clearance']>=170)]
            else:
                XD=df[(df['Body_Type']=='Sedan')&(df['Sun_Visor']=='Driver & Front Passenger')&(df['Ground_Clearance']>=170)&(df['Parking_Assistance']!='')]
        else:
            if(c<3000):
                XD=df[(df['Body_Type']=='Hatchback')&(df['City_Mileage']>23)]
            else:
                XD=df[(df['Body_Type']=='Hatchback')&(df['City_Mileage']>23)&(df['Parking_Assistance']!='')]
    ZD=XD.reset_index()
    return(ZD[['Make','Model','Ex-Showroom_Price']])