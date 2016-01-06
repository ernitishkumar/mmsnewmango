<jsp:useBean id='userBean' scope='session' class='mms.mongo.beans.User'/>
<jsp:setProperty name='userBean' property='*'/>
<jsp:forward page='/Login'/>
