FROM amazonlinux:2 as amazonlinux2

RUN yum update -y
RUN yum install -y wget tar gzip \
   glibc-devel zlib-devel zlib gcc libstdc++-static
RUN mkdir /graalvm
RUN wget https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-21.3.0/graalvm-ce-java11-linux-amd64-21.3.0.tar.gz
RUN tar -zxvf graalvm-ce-java11-linux-amd64-21.3.0.tar.gz -C /graalvm
RUN /graalvm/graalvm-ce-java11-21.3.0/bin/gu install native-image

COPY . /app
WORKDIR /app

ENV JAVA_HOME /graalvm/graalvm-ce-java11-21.3.0
RUN export JAVA_HOME

RUN ./mvnw -Pnative clean package

CMD ["sleep", "infinity"]
