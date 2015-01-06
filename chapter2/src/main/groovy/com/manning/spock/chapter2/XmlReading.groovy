package com.manning.spock.chapter2

def xmlRoot = new XmlSlurper().parse('src/main/resources/employee-data.xml')
assert xmlRoot.department.size() ==1
assert xmlRoot.department.@name =="sales"
assert xmlRoot.department.employee.size() ==2
assert xmlRoot.department.employee[0].firstName =="Orlando"
assert xmlRoot.department.employee[0].lastName =="Boren"
assert xmlRoot.department.employee[0].age ==24
assert xmlRoot.department.employee[1].firstName =="Diana"
assert xmlRoot.department.employee[1].lastName =="Colgan"
assert xmlRoot.department.employee[1].age ==28
