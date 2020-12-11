<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
    <div id="content-header">
        <div id="breadcrumb"> 
            <a href="<%=request.getContextPath()%>/base/manager/home" title="Go to Home" class="tip-bottom">
                <i class="icon-home"></i> Home
            </a>
            <a href="#">Form elements</a>
            <a href="#" class="current">Form wizard</a>
        </div>
        <h1>Form wizard</h1>

    </div>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title">
                        <span class="icon">
                            <i class="icon-pencil"></i>
                        </span>
                        <h5>Form wizard &amp; validation</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form id="form-wizard" class="form-horizontal" method="post">
                            <div id="form-wizard-1" class="step">
                                <div class="control-group">
                                    <label class="control-label">Username</label>
                                    <div class="controls">
                                        <input id="username" type="text" name="username" />
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Password</label>
                                    <div class="controls">
                                        <input id="password" type="password" name="password" />
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Confirm Password</label>
                                    <div class="controls">
                                        <input id="password2" type="password" name="password2" />
                                    </div>
                                </div>
                            </div>
                            <div id="form-wizard-2" class="step">
                                <div class="control-group">
                                    <label class="control-label">Email</label>
                                    <div class="controls">
                                        <input id="email" type="text" name="email" />
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">EULA</label>
                                    <div class="controls">
                                        <input id="eula" type="checkbox" name="eula" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <input id="back" class="btn btn-primary" type="reset" value="Back" />
                                <input id="next" class="btn btn-primary" type="submit" value="Next" />
                                <div id="status"></div>
                            </div>
                            <div id="submitted"></div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script src="<c:url value='/js/jquery.ui.custom.js' />"></script>
<script src="<c:url value='/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/js/jquery.validate.js' />"></script>
<script src="<c:url value='/js/jquery.wizard.js' />"></script>
<script src="<c:url value='/js/maruti.js' />"></script>
<script src="<c:url value='/js/maruti.wizard.js' />"></script>