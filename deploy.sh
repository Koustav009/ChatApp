#!/bin/bash

# Define variables
JAR_NAME="Websocket-0.0.2-SNAPSHOT.jar"
LOCAL_JAR_PATH="./target/$JAR_NAME"
# REMOTE_USER="ubuntu"      # Your remote user
REMOTE_HOST="Oracle-Koustav-cloud-test01"  # Your server alias or IP
REMOTE_DIR="~/websocket-bkend"

echo "Transferring JAR to the server..."
scp "$LOCAL_JAR_PATH" "$REMOTE_HOST:$REMOTE_DIR/" || { echo "SCP failed!"; exit 1; }

echo "Restarting Java application on the server..."
ssh "$REMOTE_HOST" <<EOF
    cd $REMOTE_DIR

    # Find and stop the existing Java process
    PID=\$(pgrep -f "$JAR_NAME")
    if [ -n "\$PID" ]; then
        echo "Stopping existing Java process with PID: \$PID"
        kill -9 "\$PID"
        sleep 2
    else
        echo "No existing Java process found."
    fi

    # Start the new JAR
    echo "Starting new Java application..."
    nohup java -jar "$JAR_NAME" > app.log 2>&1 &

    NEW_PID=\$!
    echo "New Java process started with PID: \$NEW_PID"
EOF

echo "✅ Deployment completed!"
