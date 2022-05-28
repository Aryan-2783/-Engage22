from os.path import dirname ,join
import numpy as np
import pandas as pd
def demo(num1,num2,num3):
    filename=join(dirname(__file__),"libs2/cars_engage_2022(2).csv")
    df=pd.read_csv(filename)
    a=int(num1)
    b=int(num2)
    c=int(num3)
    if(a<=30000):
        if(c>20 and c<=30):
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<800000)&(df['Body_Type']=="Hatchback")]
        elif(c>30 and c<=40):
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<800000)&(df['Body_Type']=="Sedan")]
        else:
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<800000)&(df['Body_Type']=="SUV")]
    elif(a>30000 and a<=60000):
        if(c>20 and c<=30):
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<1500000)&(df['Ex-Showroom_Price']>800000)&(df['Body_Type']=="Hatchback")]
        elif(c>30 and c<=40):
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<1500000)&(df['Ex-Showroom_Price']>800000)&(df['Body_Type']=="Sedan")]
        else:
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<1500000)&(df['Ex-Showroom_Price']>800000)&(df['Body_Type']=="SUV")]
    else:
        if(c>20 and c<=30):
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<4500000)&(df['Ex-Showroom_Price']>2500000)&(df['Body_Type']=="Hatchback")]
        elif(c>30 and c<=40):
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<4500000)&(df['Ex-Showroom_Price']>2500000)&(df['Body_Type']=="Sedan")]
        else:
            XD=df[(df['Seating_Capacity']>=b)&(df['Ex-Showroom_Price']<4500000)&(df['Ex-Showroom_Price']>2500000)&(df['Body_Type']=="SUV")]
    ZD=XD.reset_index()
    return(ZD[['Make','Model','Ex-Showroom_Price']])
