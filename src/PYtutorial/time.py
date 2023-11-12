from datetime import datetime
from datetime import date

now = datetime.now()
today = date.today()

current_time = now.strftime("%H:%M:%S")
current_date = today.strftime("%d-%m-%Y")
