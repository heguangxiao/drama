<div id="sidebar">
    <a href="#" class="visible-phone">
        <i class="icon icon-home"></i> 
        Home
    </a>
    <ul>
        <li class="active">
            <a href="<%=request.getContextPath()%>/base/manager">
                <i class="icon icon-home"></i>
                <span>Home</span>
            </a> 
        </li>
        <li> 
            <a href="<%=request.getContextPath()%>/base/manager/charts">
                <i class="icon icon-signal"></i>
                <span>Charts &amp; graphs</span>
            </a> 
        </li>
        <li> 
            <a href="<%=request.getContextPath()%>/base/manager/widgets">
                <i class="icon icon-inbox"></i>
                <span>Widgets</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/base/manager/tables">
                <i class="icon icon-th"></i>
                <span>Tables</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/base/manager/grid">
                <i class="icon icon-fullscreen"></i>
                <span>Full width</span>
            </a>
        </li>
        <li class="submenu"> 
            <a href="#">
                <i class="icon icon-th-list"></i>
                <span>Forms</span>
                <span class="label label-important">3</span>
            </a>
            <ul>
                <li><a href="<%=request.getContextPath()%>/base/manager/form-common">Basic Form</a></li>
                <li><a href="<%=request.getContextPath()%>/base/manager/form-validation">Form with Validation</a></li>
                <li><a href="<%=request.getContextPath()%>/base/manager/form-wizard">Form with Wizard</a></li>
            </ul>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/base/manager/buttons">
                <i class="icon icon-tint"></i> 
                <span>Buttons &amp; icons</span>
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/base/manager/interface">
                <i class="icon icon-pencil"></i> 
                <span>Eelements</span>
            </a>
        </li>
        <li class="submenu"> 
            <a href="#">
                <i class="icon icon-file"></i>
                <span>Addons</span> 
                <span class="label label-important">3</span>
            </a>
            <ul>
                <li><a href="<%=request.getContextPath()%>/base/manager/gallery">Gallery</a></li>
                <li><a href="<%=request.getContextPath()%>/base/manager/calendar">Calendar</a></li>
                <li><a href="<%=request.getContextPath()%>/base/manager/chat">Chat option</a></li>
            </ul>
        </li>
    </ul>
</div>