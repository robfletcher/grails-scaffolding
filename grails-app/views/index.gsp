<!doctype html>
<html>
    <head>
		<meta name="layout" content="main" />
		<title>Welcome to Grails</title>
        <style type="text/css" media="screen">
        #status {
			background-color: #eee;
			border: .3em solid #fff;
            margin: 1.5em;
			padding: 1.5em;
            width: 19em;
            float: left;
		     -moz-box-shadow: 0px 0px 2em #ccc; 
		  -webkit-box-shadow: 0px 0px 2em #ccc; 
		          box-shadow: 0px 0px 2em #ccc; 
          -moz-border-radius: 1em; 
	   -webkit-border-radius: 1em; 
	           border-radius: 1em; 
        }
		.boxshadow #status {
			margin: 1.5em 3.5em;
		}
		.ie6 #status {
			display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
		}
		#status ul {
			font-size: 1.5em;
            list-style-type: none;
            margin-bottom: 1em;
        }
        #status h1 {
            text-transform: uppercase;
            font-size: 1.8em;
            margin: 0 0 .5em;
        }
        #page-body {
            margin-left: 25.6em;
            margin-right: 1.5em;
        }
		.boxshadow #page-body {
			margin-left: 29.6em;
		}
        h2 {
            margin-top: 1em;
            margin-bottom: 0.5em;
            font-size: 1.3em;
        }
		p {
			font-size: 1.5em;
		}
		li.controller {
			font-size: 1.5em;
		}
        </style>
    </head>
    <body>
        <div id="status" role="complementary">
	        <h1>Application Status</h1>
	        <ul>
	            <li>App version: <g:meta name="app.version"></g:meta></li>
	            <li>Grails version: <g:meta name="app.grails.version"></g:meta></li>
	            <li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
	            <li>JVM version: ${System.getProperty('java.version')}</li>
	            <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
	            <li>Domains: ${grailsApplication.domainClasses.size()}</li>
	            <li>Services: ${grailsApplication.serviceClasses.size()}</li>
	            <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
	        </ul>
	        <h1>Installed Plugins</h1>
	        <ul>
	            <g:set var="pluginManager" value="${applicationContext.getBean('pluginManager')}"/>
	            <g:each var="plugin" in="${pluginManager.allPlugins}">
	                <li>${plugin.name} - ${plugin.version}</li>
	            </g:each>
	        </ul>
        </div>
        <div id="page-body" role="main">
            <h1>Welcome to Grails</h1>
            <p>Congratulations, you have successfully started your first Grails application! At the moment
            this is the default page, feel free to modify it to either redirect to a controller or display whatever
            content you may choose. Below is a list of controllers that are currently deployed in this application,
            click on each to execute its default action:</p>

            <div id="controller-list" class="dialog" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
                    </g:each>
                </ul>
            </div>
        </div>
    </body>
</html>
