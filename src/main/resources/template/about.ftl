<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Flying Saucer: CSS List Support</title>
    <link rel="stylesheet" type="text/css" href="general.css" title="Style" media="screen"/>
    <style type="text/css">
        html {
            background-color: transparent;
        }

        body {
            background-color: white;
            border: 0px;
            margin: 0;
            padding: 15;
            text-align: center;
            /*font-family: Arial Unicode MS;*/
            font-family: SimSun; /*宋体*/
        }

        p {
            font-size: 10pt;
        }
    </style>
</head>
<body>
<div style="border: 1px dotted blue; padding: 10px">
    <p id="fslogo">Flying Saucer</p>
    <img src="images/aaa.jpg" alt=""/>
    <img src="http://fwboss.oss-cn-szfinance.aliyuncs.com/87d2f6ca2aca4b11884221fcf84487cc" alt=""/>
    <p id="pagebyline">Browser Application Demo</p>


    <p>An example of integrating Flying 范德萨发生的  in a real application.</p>
    <p><em>(This is not a real web browser)</em></p>


    <p>Licensed under the GNU Lesser General Public License.</p>
</div>
<h1>hello word!</h1>
<h1>你好，世界！</h1>
<#list 1..10 as x>
<h5>===== ${x} =====</h5>
<div style="border:1px solid red;color:red;">
    <h1>${name}</h1>
    <h2>${age}</h2>
    <h3>${time?string("yyyy-MM-dd")}</h3>
</div>
</#list>
</body>
</html>
