import imaplib
import email

user="your email"
password="your password"
con=imaplib.IMAP4_SSL('imap.gmail.com')
con.login(user,password)
con.list()
import re
def striphtml(data):
    p = re.compile(r'<.*?>')
    return p.sub('', data)

c=(int(con.select("INBOX")[1][0]))
for j in range (c,c-25,-1):
    result,data=con.fetch(str(j), '(RFC822)')
    email_message=email.message_from_string(data[0][1].decode('utf-8'))
    for part in email_message.walk():
      content_type=part.get_content_type()
      if "plain" in content_type:
        x=(striphtml(part.get_payload()))
        l=x.split()
        l2=[]
        for i in l:
            if str(i)[0]!="<" and str(i)[-1]!=">" and  len(str(i))<20:
              l2.append(i)
        " ".join(l2)
        s=""
        for i in l2:
             s=s+i+" "
    
    f=open("file"+str(j)+".txt","w+")
    f.write("Date:")
    f.write(email_message['Date'])
    f.write("\n")
    f.write("From:")
    f.write(email_message['From'])
    f.write("\n")

    f.write("\n")

    f.write("body:-")
    f.write("/")
    f.write(s)
    f.close()

