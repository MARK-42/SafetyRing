import os
myCmd = 'arecord --device=hw:1,0 --format S16_LE --rate 44100 -V mono -c1 voice13.wav'
os.system(myCmd)

