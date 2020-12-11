<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
    <div id="content-header">
        <div id="breadcrumb"> 
            <a href="<%=request.getContextPath()%>/base/manager/home" title="Go to Home" class="tip-bottom">
                <i class="icon-home"></i> Home
            </a>
            <a href="#">Sample pages</a>
            <a href="#" class="current">Chat option</a>
        </div>
        <h1>Chat option</h1>

    </div>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box widget-chat">
                    <div class="widget-title">
                        <span class="icon">
                            <i class="icon-comment"></i>
                        </span>
                        <h5>Let's do a chat</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <div class="chat-users panel-right2">
                            <div class="panel-title">
                                <h5>Online Users</h5>
                            </div>
                            <div class="panel-content nopadding">
                                <ul class="contact-list">
                                    <li id="user-Sunil" class="online"><a href=""><img alt="" src="<c:url value='/img/demo/av1.jpg' />" /> <span>Sunil</span></a></li>
                                    <li id="user-Laukik"><a href=""><img alt="" src="<c:url value='/img/demo/av2.jpg' />" /> <span>Laukik</span></a></li>
                                    <li id="user-vijay" class="online new"><a href=""><img alt="" src="<c:url value='/img/demo/av3.jpg' />" /> <span>Vijay</span></a><span class="msg-count badge badge-info">3</span></li>
                                    <li id="user-Jignesh" class="online"><a href=""><img alt="" src="<c:url value='/img/demo/av4.jpg' />" /> <span>Jignesh</span></a></li>
                                    <li id="user-Malay" class="online"><a href=""><img alt="" src="<c:url value='/img/demo/av5.jpg' />" /> <span>Malay</span></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="chat-content panel-left2">
                            <div class="chat-messages" id="chat-messages">
                                <div id="chat-messages-inner"></div>
                            </div>
                            <div class="chat-message well">
                                <button class="btn btn-success">Send</button>
                                <span class="input-box">
                                    <input type="text" name="msg-box" id="msg-box" />
                                </span> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script src="<c:url value='/js/jquery.ui.custom.js' />"></script>
<script src="<c:url value='/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/js/maruti.js' />"></script>
<script src="<c:url value='/js/maruti.chat.js' />"></script> 