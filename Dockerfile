FROM ubuntu:latest
LABEL authors="anyth"

ENTRYPOINT ["top", "-b"]