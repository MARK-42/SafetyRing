import face_recognition
import cv2
import numpy as np

print("Starting the model.....")    

video_capture = cv2.VideoCapture(0)


#obama_image = face_recognition.load_image_file("obama.jpg")
#obama_face_encoding = face_recognition.face_encodings(obama_image)[0]

#harsh_image = face_recognition.load_image_file("harsh.jpg")
#harsh_face_encoding = face_recognition.face_encodings(harsh_image)[0]

#beohar_image = face_recognition.load_image_file("beohar.jpg")
#beohar_face_encoding = face_recognition.face_encodings(beohar_image)[0]

#mehul_image = face_recognition.load_image_file("mehul.jpg")
#mehul_face_encoding = face_recognition.face_encodings(mehul_image)[0]

#dhruv_image = face_recognition.load_image_file("dhruv.jpeg")
#dhruv_face_encoding = face_recognition.face_encodings(dhruv_image)[0]

#manav_image = face_recognition.load_image_file("manav.jpeg")
#manav_face_encoding = face_recognition.face_encodings(manav_image)[0]

#rahul_image = face_recognition.load_image_file("rahul.jpeg")
#rahul_face_encoding = face_recognition.face_encodings(rahul_image)[0]

#bineet_image = face_recognition.load_image_file("bineet.jpeg")
#bineet_face_encoding = face_recognition.face_encodings(bineet_image)[0]

#ritik_image = face_recognition.load_image_file("ritik.jpeg")
#ritik_face_encoding = face_recognition.face_encodings(ritik_image)[0]

#sahil_image = face_recognition.load_image_file("sahil.jpeg")
#sahil_face_encoding = face_recognition.face_encodings(sahil_image)[0]

#anshul_image = face_recognition.load_image_file("anshul.jpg")
#anshul_face_encoding = face_recognition.face_encodings(anshul_image)[0]

#saumya_image = face_recognition.load_image_file("saumya.jpeg")
#saumya_face_encoding = face_recognition.face_encodings(saumya_image)[0]

#venkatsir_image = face_recognition.load_image_file("venkatsir.jpg")
#venkatsir_face_encoding = face_recognition.face_encodings(venkatsir_image)[0]

#pavansir_image = face_recognition.load_image_file("pavansir.jpeg")
#pavansir_face_encoding = face_recognition.face_encodings(pavansir_image)[0]

#javedsir_image = face_recognition.load_image_file("javedsir.jpeg")
#javedsir_face_encoding = face_recognition.face_encodings(javedsir_image)[0]

known_face_encodings = []

# Create arrays of known face encodings and their names
#known_face_encodings = [
#    obama_face_encoding,
#    harsh_face_encoding,
#    beohar_face_encoding,
#    mehul_face_encoding,
#    dhruv_face_encoding,
#    manav_face_encoding,
#    rahul_face_encoding,
#    ritik_face_encoding,
#    sahil_face_encoding,
#    bineet_face_encoding,
#    anshul_face_encoding,
#    saumya_face_encoding,
#    venkatsir_face_encoding,
#    pavansir_face_encoding,
#    javedsir_face_encoding,
#]
"""
known_face_names = [
    "Barack Obama",
    "Harsh Aryan",
    "Shivansh Beohar",
    "Mehul Arora",
    "Dhruv Agarwal",
    "Manav Vallecha",
    "Rahul Jha",
    "Ritik Raj",
    "Sahil Goyal",







    "Bineet Kumar",
    "Anshul",
    "Saumya Gupta",
    "S. Venkatesan Sir",
    "Pavan Sir",
    "Javed Sir",
]

known_face_rolls = [
    "Barack Obama",
    "itm2017003@iiita.ac.in",
    "ihm2017501@iiita.ac.in",
    "Mehul Arora",
    "Dhruv Agarwal",
    "irm2017007@iiita.ac.in",
    "Rahul Jha",
    "iim2017003@iiita.ac.in",
    "iec2017086@iiita.ac.in",
    "ism2017008@iiita.ac.in",
    "iwm2017008@iiita.ac.in",
    "iec2017047@iiita.ac.in",
    "S. Venkatesan Sir",
    "Pavan Sir",
    "Javed Sir",
]
"""

# from firebase import firebase
# import time
        

#firebase=firebase.FirebaseApplication('https://outpass2-ae30f.firebaseio.com/',None)

print("starting camera")    
max=0
while True:
    ret, frame = video_capture.read()

    rgb_frame = frame[:, :, ::-1]

    # Find all the faces and face encodings in the frame of video
    face_locations = face_recognition.face_locations(rgb_frame)
    face_encodings = face_recognition.face_encodings(rgb_frame, face_locations)
    
    count=0
    for (top, right, bottom, left), face_encoding in zip(face_locations, face_encodings):
#       matches = face_recognition.compare_faces(known_face_encodings, face_encoding)

#        name = "Unknown"

        
#        face_distances = face_recognition.face_distance(known_face_encodings, face_encoding)
#        best_match_index = np.argmin(face_distances)
#        if matches[best_match_index]:
#            name = known_face_names[best_match_index]
#            roll = known_face_rolls[best_match_index]

        # Draw a box around the face
        cv2.rectangle(frame, (left, top), (right, bottom), (0, 0, 255), 2)
        count=count+1
        if(count>max):
            max=count
        cv2.rectangle(frame, (left, bottom - 35), (right, bottom), (0, 0, 255), cv2.FILLED)
        font = cv2.FONT_HERSHEY_DUPLEX
        cv2.putText(frame, str(count), (left + 6, bottom - 6), font, 1.0, (255, 255, 255), 1)
        
#        from datetime import datetime
#        from pytz import timezone
        
#        fmt = "%Y-%m-%d %H:%M:%S %Z%z"

#        now_utc = datetime.now(timezone('UTC'))

        # Convert to Asia/Kolkata time zone
 #       now_asia =datetime.now(timezone('Asia/Calcutta'))
  


        #result = firebase.put('/outpass2-ae30f/'+name,'Roll',roll)
#        result = firebase.put('/outpass2-ae30f/'+name,'Date',str(now_asia.strftime("%m-%d-%Y")) )
#        result = firebase.put('/outpass2-ae30f/'+name,'Time',str(now_asia.strftime("%H:%M")) )
    
#        print(result)
#        print(name+"  ")


    cv2.imshow('Video', frame)
    #if(count==max):
    #    print(count)
    print(max)
    # Hit 'q' on the keyboard to quit!
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

video_capture.release()
cv2.destroyAllWindows()