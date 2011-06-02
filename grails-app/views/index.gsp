<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 0 1em 1em;
				padding: 0em 1em 1em;
				width: 14em;
				float: left;
				-moz-box-shadow: 0px 0px 0.25em #ccc;
                                -webkit-box-shadow: 0px 0px 0.25em #ccc;
				-box-shadow: 0px 0px 0.25em #ccc;
                                -moz-border-radius: 0.6em;
                                -webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}
			.boxshadow #status {
				margin: 2em 2em 1em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 1em 0 0.3em;
			}

			#page-body {
				margin: 3em 1em 1.25em 16em;
			}

			.boxshadow #page-body {
				margin-left: 20.5em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				margin: 0.25em 0 0.5em;
			}

            #page-body ul {
                list-style-position: outside;
                padding-left: 2em;
            }

            #page-body li {
                margin: 0 0 0.5em 0;
            }

			#controller-list ul {
				list-style-position: inside;
                padding-left: 0;
			}

			#controller-list li {
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body, .boxshadow #page-body {
					margin: 0 1em 1em;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Application Status</h1>
			<ul>
				<li>App version: <g:meta name="app.version"/></li>
				<li>Grails version: <g:meta name="app.grails.version"/></li>
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
			<p>This is a sandbox application for the development of changes to scaffolding targeted at Grails 1.4.</p>
			<p>The code for this application is hosted on <a href="https://github.com/robfletcher/grails-scaffolding" rel="external">GitHub</a>.
			Please feel free to fork, raise issues or contact me on <a href="http://twitter.com/rfletcherEW" rel="author">Twitter</a>
			with suggestions.</p>
			<p>Grails core will contain HTML and CSS updates and JavaScript enhancements will be provided by the <a href="https://github.com/robfletcher/grails-enhanced-scaffolding" rel="external"><em>enhanced-scaffolding</em></a>
			plugin.</p>
			<p>The <em>enhanced-scaffolding</em> plugin bundles a selection of jQuery plugins that layer over the core scaffolding. Applications using the plugin will be able to select which features are enabled. Features currently added to this demo by <em>enhanced-scaffolding</em> are:<p>
			<ul>
				<li>An AJAX loading indicator</li>
				<li>Enhanced presentation of flash messages and error messages</li>
				<li>Field errors presented as tooltips</li>
				<li>Autocompletion of many-to-many and one-to-many relationships in <em>create</em> and <em>edit</em> forms</li>
				<li>Auto-focus of first form field or first field with an error</li>
				<li><a href="http://en.wikipedia.org/wiki/Flash_of_unstyled_content" rel="external"><abbr title="Flash of unstyled content">FOUC</abbr></a> prevention by fading in the document body once it has fully loaded</li>
				<li>AJAX for paginating or sorting on <em>list</em> pages</li>
				<li>Replacing <code>&lt;select&gt;</code> elements with <code>&lt;input type="range"&gt;</code> when used for properties with the <a href="http://grails.org/doc/latest/ref/Constraints/range.html" rel="external"><em>range</em></a> constraint.</li>
			</ul>
			<p>The application should be 100% usable even with JavaScript disabled. There are also a number of display optimisations for mobile devices included in Grails core as of version 1.4.</p>
			<p>Below is a list of controllers that are currently deployed in this application,
			click on each to execute its default action:</p>

			<div id="controller-list" role="navigation">
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
