#every line of the docker file is a layer
# this is the image
From alpine

#creating a user
# RUN useradd -ms /bin/sh under-control
RUN adduser -S -s /bin/sh under-control
USER under-control
WORKDIR /home/under-control/code

# this is importante
COPY --chown=100:100 ./talking.sh .
RUN chmod u+x ./talking.sh

#for the final command to be *run* after a container is built
CMD ["/bin/sh",  "./talking.sh"]
