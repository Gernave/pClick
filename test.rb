require_relative 'config/boot'
require_relative 'models/course'
require_relative 'models/question'
require_relative 'models/session'
require_relative 'models/vote'


course = Course.find_or_create_by(course_name: 'CS 141')
session = Session.find_or_create_by(course: course)
question = Question.find_or_create_by(name: "Is 10.4 double?", session: session, answer: 'A', start_time: "12:34:32", stop_time: "12:35:54")
vote = Vote.find_or_create_by(clickerID: "#43216453", question: question, fanst: "24:60", fans: 'C', anst: "14:43", ans: 'A')