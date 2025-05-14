#every line of the docker file is a layer
# this is the image
From node

#creating a user
RUN useradd -ms /bin/bash under-control
USER under-control
WORKDIR /home/under-control/code

# this is importante
COPY --chown=under-control ./talking.sh .
RUN chmod u+x ./talking.sh

#for the final command to be *run* after a container is built
CMD ["/bin/bash",  "./talking.sh"]
