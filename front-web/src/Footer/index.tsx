import './styles.css';
import { ReactComponent as YoutubeIcon } from './youtube.svg';
import { ReactComponent as InstagranIcon} from './instagram.svg';
import { ReactComponent as LinkedinIcon } from './linkedin.svg';

const Footer = () => (
  <footer className="main-footer">
    App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
    <div className="footer-icons">
      <a href="https://www.youtube.com/" target="_blank"> <YoutubeIcon/> </a>
      <a href="https://www.instagram.com/explore/search/" target="_blank"> <InstagranIcon/> </a>
      <a href="https://www.linkedin.com/in/jose-duque-29a944100/" target="_blank"> <LinkedinIcon/> </a>
    </div>
  </footer>
);

export default Footer;