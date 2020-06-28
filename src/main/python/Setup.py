from dotenv import load_dotenv
from pathlib import Path  

class Setup:
    def __init__(self):
        super().__init__()
        load_dotenv()
        #put .env files into environment variables
        env_path = Path('.') / '.env'
        load_dotenv(dotenv_path=env_path)