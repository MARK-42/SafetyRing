from PIL import Image
import face_recognition

import pyrebase

config = {
  "apiKey": "AIzaSyCseTBfi4W4kIlrDtf_pKan2tyKK-wThZs",
  "authDomain": "ring-30c80.firebaseapp.com",
  "databaseURL": "https://ring-30c80.firebaseio.com",
  "storageBucket": "ring-30c80.appspot.com"

}

firebase = pyrebase.initialize_app(config)

storage = firebase.storage()

for i in range(1,30):
    path_on_cloud = ('images/image%s.jpg' % i)
    path_local= ('images/image%s.jpg' % i)

    storage.child(path_on_cloud).download(path_local)


    # Load the jpg file into a numpy array
    image = face_recognition.load_image_file('images/image%s.jpg' % i)

    # Find all the faces in the image using the default HOG-based model.
    # This method is fairly accurate, but not as accurate as the CNN model and not GPU accelerated.
    # See also: find_faces_in_picture_cnn.py
    face_locations = face_recognition.face_locations(image)
    if(len(face_locations)!=0):
        print("I found {} face(s) in photograph %s".format(len(face_locations)) % i)

    for face_location in face_locations:

        # Print the location of each face in this image
        top, right, bottom, left = face_location
        print("A face is located at pixel location Top: {}, Left: {}, Bottom: {}, Right: {}".format(top, left, bottom, right))

        # You can access the actual face itself like this:
        #face_image = image[top:bottom, left:right]
        #pil_image = Image.fromarray(face_image)
        #pil_image.show()
