  # http://www.nokogiri.org/tutorials/searching_a_xml_html_document.html


    require 'rubygems'
    require 'nokogiri'



    require_relative 'config/boot'
    require_relative 'models/course'
    require_relative 'models/question'
    require_relative 'models/session'
    require_relative 'models/vote'


  def parseXML(filename, picname)
    page = Nokogiri::XML(open(filename))
    puts page.class

    filname = filename.to_s
    #puts "Filename is " + filname



    sortcq = picname.match(/_(\w)/)
    sortcq = sortcq.captures
    sortcq = sortcq.join(" ")

   # puts "Sorted is " + sortcq

    dec = sortcq <=> 'Q'


    puts "Picture is " + picname + " == " + sortcq + " == " + dec.to_s

   # pictures = File.open(picname, "rb"){|io|io.read}






    cname = filname.match(/^([^\/]+)/)
    cname = cname.captures
    cname = cname.join(" ")
  #  puts "Class name is " + cname


    #course = Course.find_or_create_by(course_name: cname)
    # session = Session.find_or_create_by(course: course)
    sessdate = filname.match(/L(\d{6})/)
    sessdate = sessdate.captures
    sessdate = sessdate.join(" ")
    puts "Session Dates is " + sessdate


    page.css('//ssn//p').each do |a|
     # session = Session.find_or_create_by(course: course, date: sessdate)
      start =  a['strt']
      duration = start.match(/(\d+):(\d+):(\d+)/)
      hour,min,sec = duration.captures

    #  puts "Hour is: " + hour + " Min is " + min + " Sec is " + sec


      stop = a['stp']
      duration2 = stop.match(/(\d+):(\d+):(\d+)/)
      hour2,min2,sec2 = duration2.captures

     # puts "Hour2 is: " + hour2 + " Min2 is " + min2 + " Sec2 is " + sec2

        hour = hour.to_i
        min = min.to_i
        sec = sec.to_i

      hour2 = hour2.to_i
      min2 = min2.to_i
      sec2 = sec2.to_i

      fhour = hour2 - hour
      fmin = min2 - min
      fsec = sec2 - sec

      if fsec < 0
        fsec = -(fsec)
      end


     # puts "FHour is: " + fhour.to_s + " fmin is " + fmin.to_s + " fsec is " + fsec.to_s

     fhour = fhour.to_s
      fmin = fmin.to_s
      fsec = fsec.to_s


      if fhour.length == 1
        fhour = "0"+fhour
      end

      if fmin.length == 1
        fmin = "0"+fmin
      end

      if fsec.length == 1
        fsec = "0" + fsec
      end


      fduration = fhour + ":" + fmin + ":" + fsec

      #puts "Fduration is " + fduration

     # puts a['qn'] + " " + "Start Time: " + a['strt'] + " " + "Stop Time: " + a['stp']
   #   question = Question.find_by(name: a['qn'], session: session, answer: 'A', start_time: a['strt'], duration: fduration, picture: pictures)
    #  if question == nil
     #   question = Question.find_or_create_by(name: a['qn'], session: session, answer: 'A', start_time: a['strt'], duration: fduration, picture: pictures)
     # end
=begin
      puts "What is the correct answer for " + a['qn']+ " ?"
      input = gets.chomp
      input = input.upcase



      if input != nil
        question.update(answer: input)
      end
=end




      page.css('//ssn//p//v').each do |e|

      #  puts e['id'] + " " + "Given answer: " + e['ans'] + " " + "First Answer Time " +  e['fanst'] + " " + e['fans'] + " " + e['tm']

        if e['id']!=nil && e['ans'] == nil
          e['ans'] = "N"
        end

        if e['id']!=nil && e['fans'] == nil
          e['fans'] = "N"
        end

        if e['id']!=nil && e['fanst'] == nil
          e['fanst'] = "XX:XX:XX"
        end

        if e['id']!=nil && e['tm'] == nil
          e['tm'] = "XX:XX:XX"
        end





       # vote = Vote.find_by(clickerID: e['id'], question: question, fanst: e['fanst'], fans: e['fans'], anst: e['tm'], ans: e['ans'])
       # if vote == nil
        #  vote = Vote.find_or_create_by(clickerID: e['id'], question: question, fanst: e['fanst'], fans: e['fans'], anst: e['tm'], ans: e['ans'])

        #end
      end
    end
  end







  def main
    root = 'CS 141 FALL 2016'

    Dir[root+'/SessionData/*'].each do |session|
     # puts session

      Dir[root+'/Images/*'].each do |imags|
      #  puts imgs


            parseXML(session, imags)
        end
    end
  end


  if __FILE__ == $0
     #parseXML('CS 141 FALL 2016/SessionData/L1611021411.xml','CS 141 FALL 2016/Images/L1611021411_Q1.jpg')
    main
  end


