from os.path import dirname ,join
import numpy as np
import pandas as pd 
def safety():
    filename=join(dirname(__file__),"libs2/cars_engage_2022.csv")
    df=pd.read_csv(filename)
    XD=df[(df['Airbags']=="Driver frontal airbag, Front passenger frontal airbag")&(df['Child_Safety_Locks']=="Yes")&(df['Central_Locking']=="Yes")&(df['Parking_Assistance']=="Yes")]
    ZD=XD.reset_index()
    return(ZD[['Make','Model','Variant']])


