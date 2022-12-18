import React from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faStickyNote, faCar, faComment, faThumbsUp, faThumbsDown} from '@fortawesome/free-solid-svg-icons'
import "./Blog.css"

function Blog(props){

    return(
      <div className={"Blog"}>
          <Container>
              <Row>
                  <h1>{props.title}</h1>
              </Row>
              <Row>
                  <Col>
                      <FontAwesomeIcon icon={faCar} size={256} />
                  </Col>
                  <Col>
                      <p>{props.description}</p>
                  </Col>
              </Row>
              <Row>
                  <Col>
                      <FontAwesomeIcon icon={faStickyNote} />
                      <p>{props.posts}</p>
                  </Col>
                  <Col>
                      <FontAwesomeIcon icon={faComment} />
                      <p>{props.comments}</p>
                  </Col>
                  <Col>
                      <FontAwesomeIcon icon={faThumbsUp} />
                      <p>{props.likes}</p>
                  </Col>
                  <Col>
                      <FontAwesomeIcon icon={faThumbsDown} />
                      <p>{props.dislikes}</p>
                  </Col>
              </Row>
              <Row>
                  <p>{"Last Update: " + props.lastUpdate}</p>
              </Row>
          </Container>
      </div>
    );
}

export default Blog;